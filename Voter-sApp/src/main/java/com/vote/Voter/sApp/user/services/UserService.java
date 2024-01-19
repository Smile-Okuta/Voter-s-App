package com.vote.Voter.sApp.user.services;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.request.LoginRequest;
import com.vote.Voter.sApp.user.dto.request.VoteCandidateRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.dto.response.VoteCandidateResponse;

import java.util.List;

public interface UserService {
CreateUserResponse createUser (CreateUserRequest userRequest);
void login(LoginRequest loginRequest);
VoteCandidateResponse voteCandidate(VoteCandidateRequest voteRequest);
List<BallotModel> viewAvailableBallot(Long userId);
}
