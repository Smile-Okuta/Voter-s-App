package com.vote.Voter.sApp.user.dto.response;

import com.vote.Voter.sApp.user.enums.UserRole;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserResponse {
private String message;
private UserRole userRole;
}
