package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private PvcModel pvc;
    private String phoneNumber;
    private Gender gender;;
    private CreateAddress createAddress;
    private String stateOfOrigin;
    private String dateOfBirth;
    private String occupation;

}
