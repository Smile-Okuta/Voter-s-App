package com.vote.Voter.sApp.ballot.dto.request;

import com.vote.Voter.sApp.ballot.enums.BallotStatus;
import com.vote.Voter.sApp.user.models.CandidateModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class CreateBallotRequest {
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BallotStatus ballotStatus;
}
