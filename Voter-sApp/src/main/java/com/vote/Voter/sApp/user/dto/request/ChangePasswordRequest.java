package com.vote.Voter.sApp.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {

    private String pvcNumber;
    private String oldPassword;
    private String newPassword;

}

