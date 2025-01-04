package com.vote.Voter.sApp.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForgetPasswordRequest {

    private String phoneNumber;
    private String pvcNumber;

}
