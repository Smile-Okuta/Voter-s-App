package com.vote.Voter.sApp.user.services;

import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;

public interface UserService {
CreateUserResponse createUser (CreateUserRequest userRequest);
}
