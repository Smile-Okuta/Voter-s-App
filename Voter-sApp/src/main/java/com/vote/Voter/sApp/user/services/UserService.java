package com.vote.Voter.sApp.user.services;

import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.request.LoginRequest;
import com.vote.Voter.sApp.user.dto.request.VoteRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.dto.response.VoteCandidateResponse;
import com.vote.Voter.sApp.user.models.UserModel;

import java.util.List;

public interface UserService {
CreateUserResponse createUser (CreateUserRequest userRequest);
String login(LoginRequest loginRequest);
UserModel updateUser(CreateUserRequest createUserRequest, Long id);
//VoteCandidateResponse voteCandidate(VoteRequest voteRequest);

List<UserModel> getAllUser();
UserModel getUserById(Long id);


}

