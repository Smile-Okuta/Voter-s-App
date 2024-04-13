package com.vote.Voter.sApp.user.servicesImpl;

import com.vote.Voter.sApp.ballot.enums.BallotTitle;
import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.ballot.services.BallotService;
import com.vote.Voter.sApp.candidate.models.CandidateModel;
import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.request.LoginRequest;
import com.vote.Voter.sApp.user.dto.request.ViewBallotRequest;
import com.vote.Voter.sApp.user.dto.request.VoteCandidateRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.dto.response.VoteCandidateResponse;
import com.vote.Voter.sApp.user.enums.UserRole;
import com.vote.Voter.sApp.user.exception.AlreadyExistException;
import com.vote.Voter.sApp.user.exception.NotFoundException;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import com.vote.Voter.sApp.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CandidateModel candidateModel;
    private final BallotService ballotService;
    private final ModelMapper modelMapper;



    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        UserModel userModel = createNewUser(userRequest);
        userExist(userRequest);
        UserModel user = userRepository.save(userModel);
        return CreateUserResponse.builder()
                .message("Voter Account created Successfully")
//                .userRole(user.getRole())
                .build();

    }

    private void userExist(CreateUserRequest createUserRequest){
        boolean isUserExist = userRepository.existsByPvc(createUserRequest.getPvcNumber());
        if (isUserExist){
            throw new AlreadyExistException("User Already Exist");
        }

    }

    private UserModel createNewUser(CreateUserRequest createUserRequest){
        UserModel userModel = modelMapper.map(createUserRequest, UserModel.class);
//        LocalDate dateOfBirth = convertDateStringToLocalDate(createUserRequest.getDateOfBirth());
//        userModel.setDateOfBirth(dateOfBirth);
        passwordEncoder.encode(registerRequest.getPassword());
        return userModel;
    }

    private LocalDate convertDateStringToLocalDate(String dateOfBirth){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }



    @Override
    public void login(LoginRequest loginRequest) {
        loginDetailsExist(loginRequest);
    }

    @Override
    public VoteCandidateResponse voteCandidate(VoteCandidateRequest voteRequest) {
        return null;
    }

    @Override
    public List<BallotModel> viewAvailableBallot(ViewBallotRequest userId) {
        return null;
    }

    private void loginDetailsExist(LoginRequest loginRequest){
        boolean emailExist = userRepository.existsByEmail(loginRequest.getEmail());
        boolean passwordExist = userRepository.existsByPassword(loginRequest.getPassword());
        if (! emailExist && ! passwordExist ){
            throw new NotFoundException("Email Address or Password is incorrect or does not exist");
        }
    }


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

    private UserModel getByPvc(String pvc){
        return userRepository.findByPvc(pvc).orElseThrow(
                ()-> new NotFoundException("User With The Provided Information Not Found"));
    }




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



