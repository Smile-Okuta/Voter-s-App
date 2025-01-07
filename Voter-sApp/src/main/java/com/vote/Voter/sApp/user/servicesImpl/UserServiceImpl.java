package com.vote.Voter.sApp.user.servicesImpl;

import com.vote.Voter.sApp.pvc.models.AddressModel;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.pvc.repositories.PvcRepository;
import com.vote.Voter.sApp.user.dto.request.*;
import com.vote.Voter.sApp.user.exception.AlreadyExistException;
import com.vote.Voter.sApp.user.exception.UserNotFoundException;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import com.vote.Voter.sApp.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PvcRepository pvcRepository;
    private final SecureRandom secureRandom = new SecureRandom();


    @Override
    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public String createUser(CreateUserRequest userRequest) {
        if (userExist(userRequest.email())) {
            throw new AlreadyExistException(userRequest.email() + " already exist");
        }

        var userModel = createNewUser(userRequest);
        userRepository.save(userModel);
        return "Account created successfully";

    }

    private boolean userExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


    private UserModel createNewUser(CreateUserRequest createUserRequest) {
        UserModel userModel = new UserModel();

        userModel.setFirstName(createUserRequest.firstName());
        userModel.setLastName(createUserRequest.lastName());
        userModel.setEmail(createUserRequest.email());
        userModel.setPassword(passwordEncoder.encode(createUserRequest.password()));

        return userModel;
    }

    @Override
    public void validateUser (String email){

    }

    @Override
    public String login(LoginRequest loginRequest) {
        Optional<UserModel> userLogin = userRepository.findByEmail(loginRequest.getEmail());

        if (userLogin.isPresent()) {
            UserModel userModel = userLogin.get();

            if (passwordEncoder.matches(loginRequest.getPassword(), userModel.getPassword())) {
                return "Login Successful";
            } else {
                return "Invalid Credentials";
            }
        } else {
            return "User not found";
        }
    }


    @Override
    public UserModel updateUser(UpdateUserRequest updateUserRequest, Long id) {
        UserModel user = userRepository.findByEmail(updateUserRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User with the provided email not found."));

        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        user.setEmail(updateUserRequest.getEmail());
        user.setUsername(updateUserRequest.getUsername());
        user.setPassword(updateUserRequest.getPassword());


        PvcModel pvc = new PvcModel();
        pvc.setBvn(updateUserRequest.getPvc().getBvn());
        pvc.setLocalGovUnit(updateUserRequest.getPvc().getLocalGovUnit());
        pvc.setStateUnit(updateUserRequest.getPvc().getStateUnit());
        PvcModel savedPVC = pvcRepository.save(pvc);

        user.setPvc(savedPVC);
        user.setPhoneNumber(updateUserRequest.getPhoneNumber());
        user.setGender(updateUserRequest.getGender());

        AddressModel address = new AddressModel();
        address.setHouseNumber(updateUserRequest.getCreateAddress().getHouseNumber());
        address.setStreetName(updateUserRequest.getCreateAddress().getStreetName());
        address.setLgaName(updateUserRequest.getCreateAddress().getLgaName());
        address.setStateName(updateUserRequest.getCreateAddress().getStateName());
        user.setAddressModel(address);

        user.setStateOfOrigin(updateUserRequest.getStateOfOrigin());
        user.setDateOfBirth(convertDateStringToLocalDate(updateUserRequest.getDateOfBirth()));
        user.setOccupation(updateUserRequest.getOccupation());

        return userRepository.save(user);
    }


    @Override
    public UserModel getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Sorry, no User with this Id was found"));
    }


    @Override
    public void changePassword(ChangePasswordRequest passwordRequest) {

        UserModel user = userRepository.findByPvc(passwordRequest.getPvcNumber())
                .orElseThrow(() -> new IllegalArgumentException("Invalid PVC number."));

        if (!passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect.");
        }

        String encodedPassword = passwordEncoder.encode(passwordRequest.getNewPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public void forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
//        get PVC
//        get Email linked to the PVC
//        Generate Token
//        Send token to the email
//        save temporary token and link to the email
//        get token
//        compare received token to the one saved with the email
//        If token is correct return the userModel that's connected to the emailAddress.
//        Discard token
//        Else ("Invalid Token")

        UserModel findPvc = userRepository.findByPvc(forgetPasswordRequest.getPvcNumber())
                .orElseThrow(() -> new IllegalArgumentException("Invalid PVC number."));

        String getEmail = findPvc.getEmail();

        sendEmailToken(getEmail);


    }

    private void sendEmailToken(String email){



    }




    private String generateSecureCode() {
        int code = 100000 + secureRandom.nextInt(900000);
        return String.valueOf(code);
    }

    private LocalDate convertDateStringToLocalDate(String dateOfBirth){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }


}
