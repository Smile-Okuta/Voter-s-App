package com.vote.Voter.sApp.pvc.dto.response;

import com.vote.Voter.sApp.pvc.models.AddressModel;
import lombok.Builder;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Builder
public class RegisterResponse {
    private String message;
    private String firstName;
    private String middleName;
    private String lastName;
    private AddressModel address;
    private String stateOfOrigin;
    private String phoneNumber;
    private String generatePvcNumber;

}
