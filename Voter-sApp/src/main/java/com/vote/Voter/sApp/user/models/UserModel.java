package com.vote.Voter.sApp.user.models;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
//    @Column(unique = true)
//    private PvcModel pvcNumber;
    @Column(unique = true)
    private String nin;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String password;
    private Gender gender;
//    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
//    private UserRole role;
    private  boolean isEnabled;
}
