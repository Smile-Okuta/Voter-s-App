package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.user.enums.UserRole;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String pvcNumber;
    private String email;
    private String gender;
    private String phoneNumber;
    private String address;
    private LocalDateTime dateOfBirth;
    private UserRole role;
}
