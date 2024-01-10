package com.vote.Voter.sApp.vote.models;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.ballot.services.BallotService;
import com.vote.Voter.sApp.candidate.models.CandidateModel;
import com.vote.Voter.sApp.user.models.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.GenericArrayType;
import java.time.LocalDate;
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
