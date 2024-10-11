package com.vote.Voter.sApp.user.services;

import com.vote.Voter.sApp.ballot.models.BallotModel;
//import com.vote.Voter.sApp.user.models.BallotModel;
import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.request.LoginRequest;
import com.vote.Voter.sApp.user.dto.request.ViewBallotRequest;
import com.vote.Voter.sApp.user.dto.request.VoteCandidateRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.dto.response.VoteCandidateResponse;
import com.vote.Voter.sApp.user.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
CreateUserResponse createUser (CreateUserRequest userRequest);
String login(LoginRequest loginRequest);
UserModel updateUser(CreateUserRequest userModel, Long id);
VoteCandidateResponse voteCandidate(VoteCandidateRequest voteRequest);
List<BallotModel> viewAvailableBallot(ViewBallotRequest userId);
List<UserModel> getUser();
UserModel getUserById(Long id);
}

