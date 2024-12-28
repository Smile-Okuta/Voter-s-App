package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.pvc.dto.request.CreatePvc;
import com.vote.Voter.sApp.pvc.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private CreatePvc pvc;
    private Gender gender;
    private CreateAddress createAddress;
    private String stateOfOrigin;
    private String occupation;

}
