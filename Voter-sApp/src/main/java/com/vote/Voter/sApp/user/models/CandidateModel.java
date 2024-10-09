package com.vote.Voter.sApp.user.models;

import com.vote.Voter.sApp.ballot.enums.BallotTitle;
import com.vote.Voter.sApp.candidate.enums.Status;
import com.vote.Voter.sApp.user.models.UserModel;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class CandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private UserModel user;
    private String bio;
    @Column(unique = true)
    private String nominationNumber;
//    @Enumerated(EnumType.STRING)
//    private BallotTitle position;
//    @Enumerated(EnumType.STRING)
//    private Status status;
}
