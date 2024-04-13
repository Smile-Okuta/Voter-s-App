package com.vote.Voter.sApp.pvc.dto.request;

import com.vote.Voter.sApp.pvc.models.AddressModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Register {
    private String firstName;
    private String middleName;
    private String lastName;
    private String nin;
    private AddressModel address;
    private String stateOfOrigin;
    private String dateOfBirth;
    private String gender;
    private String occupation;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String password;
}
