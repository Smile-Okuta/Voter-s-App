package com.vote.Voter.sApp.ballot.models;

import com.vote.Voter.sApp.ballot.enums.Title;
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
@Builder
public class BallotModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Title title;
    private String description;
    @OneToMany
    private List<CandidateModel> candidate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
