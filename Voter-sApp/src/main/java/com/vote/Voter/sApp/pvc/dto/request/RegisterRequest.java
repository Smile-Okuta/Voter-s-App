package com.vote.Voter.sApp.pvc.dto.request;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {
    //    private AddressModel address;
    private String password;
    private String nin;
    private String phoneNumber;
    private Gender gender;
    private AddressRequest addressRequest;
    private String stateOfOrigin;
    private String dateOfBirth;
    private String occupation;
    private LgaName pollingUnit;

}