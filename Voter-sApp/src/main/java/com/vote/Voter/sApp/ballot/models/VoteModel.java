package com.vote.Voter.sApp.ballot.models;

import com.vote.Voter.sApp.user.models.CandidateModel;
import com.vote.Voter.sApp.user.models.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class VoteModel {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne
        private UserModel user;
        @ManyToOne
        private BallotModel ballot;
        @ManyToOne
        private CandidateModel candidate;
        private LocalDateTime dateTime;



}
