package com.vote.Voter.sApp.pvc.dto.request;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String nin;
    private Gender gender;
    private AddressModel address;
    private String stateOfOrigin;
    private int houseNumber;
    private String streetName;
    private LgaName lgaName;
    private StateName stateName;
    private String dateOfBirth;
    private String occupation;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String password;
    private LgaName pollingUnit;
}
