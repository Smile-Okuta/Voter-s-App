package com.vote.Voter.sApp.pvc.servicesImpl;

import com.vote.Voter.sApp.pvc.dto.request.RegisterRequest;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;
import com.vote.Voter.sApp.pvc.exception.NinDoesNotExistException;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.pvc.repositories.PvcRepository;
import com.vote.Voter.sApp.pvc.services.PvcService;
import com.vote.Voter.sApp.pvc.utils.GeneratePvcNumber;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class PvcServiceImpl implements PvcService {
    private final PvcRepository pvcRepository;


    @Override
    public RegisterResponse registerPvc (RegisterRequest createPvcRequest){
        PvcModel pvcModel = generateNewPvc(createPvcRequest);
        ninExist(createPvcRequest);
        PvcModel pvc = pvcRepository.save(pvcModel);
        return RegisterResponse.builder()
                .message(String.format("Congratulations %s %s, \nyou have been registered successfully\n\n", pvc.getFirstName(), pvc.getLastName()))
                .firstName(pvc.getFirstName())
                .middleName(pvc.getMiddleName())
                .lastName(pvc.getLastName())
                .stateOfOrigin(pvc.getStateOfOrigin())
                .phoneNumber(pvc.getPhoneNumber())
                .generatePvcNumber(pvc.getGeneratePvcNumber())
                .build();

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

    private void ninExist(RegisterRequest registerRequest){
        PvcModel isNinExist = pvcRepository.findByNin(registerRequest.getNin());
        if (isNinExist != null ){
            String nin1 = registerRequest.getNin();
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

    private PvcModel generateNewPvc(RegisterRequest registerRequest){
//        PvcModel pvcModel = modelMapper.map(registerRequest, PvcModel.class);
        PvcModel pvcModel = new PvcModel();
        pvcModel.setFirstName(registerRequest.getFirstName());
        pvcModel.setMiddleName(registerRequest.getMiddleName());
        pvcModel.setLastName(registerRequest.getLastName());
        pvcModel.setNin(registerRequest.getNin());
        pvcModel.setGender(registerRequest.getGender());
        pvcModel.setStateOfOrigin(registerRequest.getStateOfOrigin());
        pvcModel.setHouseNumber(registerRequest.getHouseNumber());
        pvcModel.setStreetName(registerRequest.getStreetName());
        pvcModel.setLgaName(registerRequest.getLgaName());
        pvcModel.setStateName(registerRequest.getStateName());

        LocalDate dateOfBirth = convertDateStringToLocalDate(registerRequest.getDateOfBirth());
        pvcModel.setDateOfBirth(dateOfBirth);

        pvcModel.setOccupation(registerRequest.getOccupation());
        pvcModel.setPhoneNumber(registerRequest.getPhoneNumber());
        pvcModel.setAlternativePhoneNumber(registerRequest.getAlternativePhoneNumber());
        pvcModel.setGeneratePvcNumber(GeneratePvcNumber.generateUserPvc() + "" + GeneratePvcNumber.lgaAndStateName(pvcModel.getStateName(), registerRequest.getPollingUnit()));
        return pvcModel;
    }

    private LocalDate convertDateStringToLocalDate(String dateOfBirth){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }
}
