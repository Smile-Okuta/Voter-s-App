package com.vote.Voter.sApp.user.models;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.user.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.sql.Timestamp;
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

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NaturalId
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String username;

    @Column(unique = true)
    @NotBlank
    private String password;

    @Column(unique = true)
    private PvcModel pvc;

    @Column(unique = true)
    private String phoneNumber;

    @NotEmpty
    private Gender gender;

    @ManyToOne
    @Embedded
    private AddressModel addressModel;

    @NotEmpty
    private String stateOfOrigin;

    @NotEmpty
    private LocalDate dateOfBirth;

    @NotEmpty
    private String occupation;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private UserRole role;
    private  boolean isEnabled;
    private boolean isVerified;
    @OneToOne
    private PvcModel pvcModel;
}
