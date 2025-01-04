package com.vote.Voter.sApp.user.services;

import com.vote.Voter.sApp.user.dto.request.*;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
CreateUserResponse createUser (CreateUserRequest userRequest);

String login(LoginRequest loginRequest);

UserModel updateUser(UpdateUserRequest createUserRequest, Long id);

public void validateUser (String email);

List<UserModel> getAllUser();

Optional<UserModel> findByEmail(String email);

UserModel getUserById(Long id);

public void changePassword(ChangePasswordRequest passwordRequest);

public void forgetPassword(ForgetPasswordRequest forgetPasswordRequest);

}

