package com.vote.Voter.sApp.ballot.models;

import com.vote.Voter.sApp.ballot.enums.BallotStatus;
import com.vote.Voter.sApp.ballot.enums.BallotTitle;
import com.vote.Voter.sApp.candidate.models.CandidateModel;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BallotModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BallotTitle ballotTitle;
    @Enumerated(EnumType.STRING)
    private BallotStatus ballotStatus;
    private String location;
    @OneToMany
    private List<CandidateModel> candidate;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
