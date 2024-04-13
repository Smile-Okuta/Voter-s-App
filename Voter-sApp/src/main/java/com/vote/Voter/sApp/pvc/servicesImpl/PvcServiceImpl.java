package com.vote.Voter.sApp.pvc.servicesImpl;

import com.vote.Voter.sApp.pvc.dto.request.LoginRequest;
import com.vote.Voter.sApp.pvc.dto.request.Register;
import com.vote.Voter.sApp.pvc.dto.response.LoginResponse;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;
import com.vote.Voter.sApp.pvc.exception.NinAlreadyExistException;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.pvc.repositories.PvcRepository;
import com.vote.Voter.sApp.pvc.services.PvcService;
import com.vote.Voter.sApp.pvc.utils.GeneratePvcNumber;
import com.vote.Voter.sApp.user.exception.NotFoundException;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PvcServiceImpl implements PvcService {
    private final PvcRepository pvcRepository;
    private final ModelMapper modelMapper;
    private  final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register (Register registerRequest){
        ninExist(registerRequest);
        PvcModel pvcModel = generateNewPvc(registerRequest);
        PvcModel pvc = pvcRepository.save(pvcModel);
        UserModel user = userRepository.findByNin(pvc.getNin());
        return RegisterResponse.builder()
                .message(String.format("Congratulations %s %s, \nyou have been registered successfully\n\n", user.getFirstName(), user.getLastName()))
//                .firstName(pvc.getFirstName())
//                .middleName(pvc.getMiddleName())
//                .lastName(pvc.getLastName())
                .stateOfOrigin(pvc.getStateOfOrigin())
                .phoneNumber(pvc.getPhoneNumber())
                .generatePvcNumber(GeneratePvcNumber.generateUserPvc())
                .build();

    }

    @Override
    public LoginResponse loginMessage(LoginRequest loginRequest) {

        return null;
    }
//      ** Manual User Login **
//    @Override
//    public LoginResponse loginMessage(LoginRequest loginRequest) {
//        PvcModel checkUser= pvcRepository.findByEmail(loginRequest.getEmail());
//        if (checkUser != null){
//            String password = loginRequest.getPassword();
//            String encodedPassword = checkUser.getPassword();
//            boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
//
//            if (isPasswordRight){
//                PvcModel pvcModel = pvcRepository.findOneByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
//                if (pvcModel != null){
//                    return  new LoginResponse("Login successful", true);
//                }else {
//                    return new LoginResponse("Login Failed", false);
//                }
//            }else {
//                return new LoginResponse("Password Mismatch", false);
//            }
//        }else {
//            return  new LoginResponse("Email not found", false);
//        }
//
//    }

    private boolean emailExist(String email){
        boolean isEmailExist = pvcRepository.existsByEmail(email);
        if (!isEmailExist){
            throw new NotFoundException("Email Not Found");
        }
        return true;
    }

    private void ninExist(Register registerRequest){
        boolean isNinExist = pvcRepository.existsByNin(registerRequest.getNin());
        if (isNinExist){
            throw new NinAlreadyExistException("This Nin is already registered with a Pvc");
        }
    }

    private PvcModel generateNewPvc(Register registerRequest){
        PvcModel pvcModel = modelMapper.map(registerRequest, PvcModel.class);
        LocalDate dateOfBirth = convertDateStringToLocalDate(registerRequest.getDateOfBirth());
        pvcModel.setDateOfBirth(dateOfBirth);
        return pvcModel;
    }

    private LocalDate convertDateStringToLocalDate(String dateOfBirth){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }
}
