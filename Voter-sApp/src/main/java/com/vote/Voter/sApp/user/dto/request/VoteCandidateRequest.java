package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.candidate.models.CandidateModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteCandidateRequest {
    private String pvcNumber;
    private BallotModel ballot;
    private CandidateModel candidate;
}
