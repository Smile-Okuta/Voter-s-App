package com.vote.Voter.sApp.user.models;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.user.enums.UserRole;
import jakarta.persistence.*;
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
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    @NaturalId(mutable = true)
    private String email;
//    @Column(unique = true)
//    private String userName;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private PvcModel pvc;
    @Column(unique = true)
    private String phoneNumber;
    private Gender gender;
    @ManyToOne
    private AddressModel addressModel;
    private String stateOfOrigin;
    private LocalDate dateOfBirth;
    private String occupation;
    private LocalDateTime createdAt;
    private UserRole role;
    private  boolean isEnabled;
}
