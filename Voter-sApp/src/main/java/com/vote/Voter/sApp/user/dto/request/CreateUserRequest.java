package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.user.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
