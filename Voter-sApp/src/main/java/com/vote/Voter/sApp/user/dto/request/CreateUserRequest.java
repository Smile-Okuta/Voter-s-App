package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.user.enums.UserRole;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserRequest {

    private String userName;
    private String password;
    private String email;

}
