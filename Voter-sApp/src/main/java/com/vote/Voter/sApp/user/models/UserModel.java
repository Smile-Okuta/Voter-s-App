package com.vote.Voter.sApp.user.models;

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
    private String lastName;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private String pvcNumber;
    @Column(unique = true)
    private String email;
    private String gender;
    @Column(unique = true)
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
