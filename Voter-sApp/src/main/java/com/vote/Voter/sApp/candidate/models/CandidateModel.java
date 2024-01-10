package com.vote.Voter.sApp.candidate.models;

import com.vote.Voter.sApp.ballot.enums.Title;
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
    @Enumerated(EnumType.STRING)
    private Title position;
    @Enumerated(EnumType.STRING)
    private Status status;

}
