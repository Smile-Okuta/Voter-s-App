package com.vote.Voter.sApp.user.servicesImpl;

import com.vote.Voter.sApp.pvc.models.AddressModel;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.pvc.repositories.PvcRepository;
import com.vote.Voter.sApp.user.enums.UserRole;
import com.vote.Voter.sApp.user.exception.UserNotFoundException;
import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.request.LoginRequest;
import com.vote.Voter.sApp.user.dto.request.UpdateUserRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.dto.response.VoteCandidateResponse;
import com.vote.Voter.sApp.user.exception.AlreadyExistException;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import com.vote.Voter.sApp.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private PvcRepository pvcRepository;



    @Override
    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        if (userExist(userRequest.getEmail())){
            throw new AlreadyExistException(userRequest.getEmail() + " already exist");
        }
        UserModel userModel = createNewUser(userRequest);
        userRepository.save(userModel);
        return CreateUserResponse.builder()
                .message("Voter Account created Successfully")
                .userRole(UserRole.VOTER)
                .build();

    }

    private boolean userExist(String email){
        return userRepository.findByEmail(email).isPresent();
    }



    private UserModel createNewUser(CreateUserRequest createUserRequest){
        UserModel userModel = modelMapper.map(createUserRequest, UserModel.class);;
        passwordEncoder.encode(createUserRequest.getPassword());
        return userModel;
    }



    @Override
    public String login(LoginRequest loginRequest) {
        Optional<UserModel> userLogin = userRepository.findByEmail(loginRequest.getEmail());

        if (userLogin.isPresent()){
            UserModel userModel = userLogin.get();

            if (passwordEncoder.matches(loginRequest.getPassword(), userModel.getPassword())){
                return "Login Successful";
            }else {
                return "Invalid Credentials";
            }
        }else {
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

            PvcModel pvc = new PvcModel();
            pvc.setBvn(updateUserRequest.getPvc().getBvn());
            pvc.setLocalGovUnit(updateUserRequest.getPvc().getLocalGovUnit());
            pvc.setStateUnit(updateUserRequest.getPvc().getStateUnit());
            PvcModel savedPVC = pvcRepository.save(pvc);

            user.setPvc(savedPVC);
            user.setGender(updateUserRequest.getGender());

            AddressModel address = new AddressModel();
            address.setHouseNumber(updateUserRequest.getCreateAddress().getHouseNumber());
            address.setStreetName(updateUserRequest.getCreateAddress().getStreetName());
            address.setLgaName(updateUserRequest.getCreateAddress().getLgaName());
            address.setStateName(updateUserRequest.getCreateAddress().getStateName());
            user.setAddressModel(address);

            user.setStateOfOrigin(updateUserRequest.getStateOfOrigin());
            user.setOccupation(updateUserRequest.getOccupation());

        return userRepository.save(user);
    }


    @Override
    public UserModel getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Sorry, no User with this Id was found"));
    }




    private LocalDate convertDateStringToLocalDate(String dateOfBirth){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }



//    private void loginDetailsExist(LoginRequest loginRequest){
//        Optional<UserModel> emailExist = userRepository.existsByEmail(loginRequest.getEmail());
//        boolean passwordExist = userRepository.existsByPassword(loginRequest.getPassword());
//        if (emailExist.isEmpty() && !passwordExist ){
//            throw new NotFoundException("Email Address or Password is incorrect or does not exist");
//        }
//    }

//    @Override
//    public VoteCandidateResponse voteCandidate(VoteCandidateRequest voteRequest) {
//        UserModel userModel = userRepository.getUserByPvc(voteRequest.getPvcNumber());
//        voteRequest.setBallot(userModel.getAddress());
//        voteRequest.setCandidate(userModel.set);
//
//        return VoteCandidateResponse.builder()
//                .candidate(voteRequest.getCandidate())
//                .ballot(voteRequest.getBallot())
//                .build();
//    }

//    private UserModel getByPvc(String pvc){
//        return userRepository.findByPvc(pvc).orElseThrow(
//                ()-> new NotFoundException("User With The Provided Information Not Found"));
//    }




//    @Override
//    public List<BallotModel> viewAvailableBallot(ViewBallotRequest viewBallotRequest) {
//        UserModel user = getByPvc(viewBallotRequest.getPvc());
//
//        if (user.getRole().equals(UserRole.VOTER)) {
//            viewBallotRequest.setLocation(user.getAddress());
//            viewBallotRequest.setBallotTitle(BallotTitle.PRESIDENTIAL);
//        }
//        return ballotService.getAvailableBallots(viewBallotRequest.getLocation());
//    }

//    private UserModel getUserById(){
//        return userRepository.findById(id);
//    }


}



