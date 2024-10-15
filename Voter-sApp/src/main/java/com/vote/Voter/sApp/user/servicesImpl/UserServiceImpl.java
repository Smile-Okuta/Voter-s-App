package com.vote.Voter.sApp.user.servicesImpl;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.user.enums.UserRole;
import com.vote.Voter.sApp.user.exception.UserNotFoundException;
import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.request.LoginRequest;
import com.vote.Voter.sApp.user.dto.request.ViewBallotRequest;
import com.vote.Voter.sApp.user.dto.request.VoteCandidateRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.dto.response.VoteCandidateResponse;
import com.vote.Voter.sApp.user.exception.AlreadyExistException;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import com.vote.Voter.sApp.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
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



    @Override
    public List<UserModel> getUser() {
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
    public UserModel updateUser(CreateUserRequest createUserRequest, Long id) {
        return userRepository.findById(id).map(user -> {
            user.setFirstName(createUserRequest.getFirstName());
            user.setMiddleName(createUserRequest.getMiddleName());
            user.setLastName(createUserRequest.getLastName());
            user.setEmail(createUserRequest.getEmail());
            user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
            user.setPhoneNumber(createUserRequest.getPhoneNumber());
            user.setGender(createUserRequest.getGender());
            user.setAddressModel(createUserRequest.getAddressModel());
            user.setStateOfOrigin(createUserRequest.getStateOfOrigin());
            LocalDate dateOfBirth = convertDateStringToLocalDate(createUserRequest.getDateOfBirth());
            user.setDateOfBirth(dateOfBirth);
            return userRepository.save(user);
        }).orElseThrow(()-> new UserNotFoundException("User not found"));
    }

    @Override 
    public VoteCandidateResponse voteCandidate(VoteCandidateRequest voteRequest) {
        return null;
    }

    @Override
    public List<BallotModel> viewAvailableBallot(ViewBallotRequest userId) {
        return null;
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



