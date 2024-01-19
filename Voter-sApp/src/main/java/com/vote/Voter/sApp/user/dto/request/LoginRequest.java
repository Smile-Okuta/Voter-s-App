package com.vote.Voter.sApp.user.dto.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
