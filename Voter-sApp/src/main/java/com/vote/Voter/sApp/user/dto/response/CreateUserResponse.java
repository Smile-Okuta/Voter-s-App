package com.vote.Voter.sApp.user.dto.response;

import com.vote.Voter.sApp.user.enums.UserRole;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class CreateUserResponse {
private String message;
private UserRole userRole;
}
