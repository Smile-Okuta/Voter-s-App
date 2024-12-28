package com.vote.Voter.sApp.pvc.models;

import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import com.vote.Voter.sApp.user.models.UserModel;
import jakarta.persistence.*;
import lombok.*;

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
    private String bvn;
    @Column(unique = true)
    private LgaName localGovUnit;
    @Column(unique = true)
    private StateName stateUnit;
    @OneToOne
    private UserModel userModel;
    private LocalDateTime createdAt;
}
