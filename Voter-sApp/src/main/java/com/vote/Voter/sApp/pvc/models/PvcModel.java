package com.vote.Voter.sApp.pvc.models;

import com.vote.Voter.sApp.user.models.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PvcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String firstName;
//    private String middleName;
//    private String lastName;
    @ManyToOne
    private Set<AddressModel> address;
    private String stateOfOrigin;
    private LocalDate dateOfBirth;
//    private String gender;
    private String occupation;
    @Column(unique = true)
//    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
//    private String password;
    @Column(unique = true)
    private String nin;
    private boolean isEnabled;

}
