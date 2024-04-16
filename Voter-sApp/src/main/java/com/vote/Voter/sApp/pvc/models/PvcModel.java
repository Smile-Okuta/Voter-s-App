package com.vote.Voter.sApp.pvc.models;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import com.vote.Voter.sApp.pvc.utils.GeneratePvcNumber;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PvcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    private String nin;
    @Column(unique = true)
    private String phoneNumber;
    private Gender gender;
    private int houseNumber;
    private String streetName;
    private LgaName lgaName;
    private StateName stateName;
    private String stateOfOrigin;
    private LocalDate dateOfBirth;
    private String occupation;
    @Column(unique = true)
    private String alternativePhoneNumber;
    private String generatePvcNumber;
    private LgaName pollingUnit;
    private LocalDateTime createdAt;
    private boolean isEnabled;

}
