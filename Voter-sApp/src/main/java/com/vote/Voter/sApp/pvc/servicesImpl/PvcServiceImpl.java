package com.vote.Voter.sApp.pvc.servicesImpl;

import com.vote.Voter.sApp.pvc.dto.request.AddressRequest;
import com.vote.Voter.sApp.pvc.dto.request.CreatePvc;
import com.vote.Voter.sApp.pvc.dto.request.UpdateRequest;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;
import com.vote.Voter.sApp.pvc.exception.NinDoesNotExistException;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.pvc.repositories.PvcRepository;
import com.vote.Voter.sApp.pvc.services.PvcService;
import com.vote.Voter.sApp.pvc.utils.GeneratePvcNumber;

import com.vote.Voter.sApp.user.exception.NotFoundException;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PvcServiceImpl implements PvcService {
    private PvcRepository pvcRepository;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private UserModel userModel;

    @Override
    public RegisterResponse registerPvc (CreatePvc createPvcRequest){
        PvcModel pvcModel = generateNewPvc(createPvcRequest);
        ninExist(createPvcRequest);
        getPassword(createPvcRequest.getPassword());
        PvcModel pvc = pvcRepository.save(pvcModel);
        return RegisterResponse.builder()
                .message(String.format("Congratulations %s %s, %n you have been registered successfully%n%n", pvc.getFirstName(), pvc.getLastName()))
                .generatePvcNumber(pvc.getGeneratePvcNumber())
                .build();

    }

    @Override
    public List<PvcModel> getAllPvc() {
        return pvcRepository.findAll();
    }

    @Override
    public RegisterResponse getPvcById(Long id) {
        PvcModel pvcModel = findPvcById(id);
        return RegisterResponse.builder()
                .firstName(pvcModel.getFirstName())
                .lastName(pvcModel.getLastName())
                .address(pvcModel.getAddressModel())
                .phoneNumber(pvcModel.getPhoneNumber())
                .stateOfOrigin(pvcModel.getStateOfOrigin())
                .build();
    }

    @Override
    public RegisterResponse updatePvc(UpdateRequest updateRequest) {

        return null;
    }

    private PvcModel findPvcById(Long id){
        return pvcRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Pvc not found"));
    }
    private void getPassword(String password){
       String userPassword = userRepository.findBy(password);
//            String password = loginRequest.getPassword();
//            String encodedPassword = checkUser.getPassword();
        if (!passwordEncoder.matches(password, userPassword)){
            throw new NotFoundException("Password does not match");
        }

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

//    private void emailExist(String email){
//        boolean isEmailExist = userRepository.findByEmail(email);
//            if (!isEmailExist){
//                throw new NotFoundException("User with this email does not exist, SignUp first");
//            }
//    }

    private void ninExist(CreatePvc createPvc){
        PvcModel isNinExist = pvcRepository.findByNin(createPvc.getNin());
        if (isNinExist != null ){
            String nin1 = createPvc.getNin();
            String nin2 = isNinExist.getNin();
            boolean isEqual = nin1.matches(nin2);
            if (isEqual){
                RegisterResponse.builder()
                        .message("Registration Successful")
                        .build();
            }
        }
         throw new NinDoesNotExistException("Incorrect NIN or User with this NIN is not registered");
    }

    private PvcModel generateNewPvc(CreatePvc createPvc, AddressRequest addressRequest){
//        PvcModel pvcModel = modelMapper.map(registerRequest, PvcModel.class);
//        PvcModel pvcModel = new PvcModel();
        userModel = userRepository.findById();

        AddressModel addressModel = new AddressModel();
        addressModel.setHouseNumber(addressRequest.getHouseNumber());
        addressModel.setStreetName(addressRequest.getStreetName());
        addressModel.setLgaName(addressRequest.getLgaName());
        addressModel.setStateName(addressRequest.getStateName());
        userModel.setAddressModel(addressModel);

        LocalDate dateOfBirth = convertDateStringToLocalDate(createPvc.getDateOfBirth());
        pvcModel.setDateOfBirth(dateOfBirth);

        pvcModel.setOccupation(createPvc.getOccupation());
        pvcModel.setPhoneNumber(createPvc.getPhoneNumber());
        pvcModel.setPollingUnit(createPvc.getPollingUnit());
        pvcModel.setGeneratePvcNumber(GeneratePvcNumber.generateUserPvc() + "" + GeneratePvcNumber.lgaAndStateName(addressModel.getStateName(), createPvc.getPollingUnit()));
        return pvcModel;
    }

    private LocalDate convertDateStringToLocalDate(String dateOfBirth){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }
}
