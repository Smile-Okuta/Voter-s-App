package com.vote.Voter.sApp.ballot.models;

import com.vote.Voter.sApp.ballot.enums.BallotStatus;
import com.vote.Voter.sApp.user.models.CandidateModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        private String title;
        @Enumerated(EnumType.STRING)
        private BallotStatus ballotStatus;
        @OneToMany
        private List<CandidateModel> candidate;
        private String description;
        private LocalDateTime startDate;
        private LocalDateTime endDate;


}
