package com.vote.Voter.sApp.pvc.models;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.enums.LgaName;
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
//    private String firstName;
//    private String middleName;
//    private String lastName;
    @Column(unique = true)
    private String generatePvcNumber;
    private LgaName pollingUnit;
    private LocalDateTime createdAt;
}
