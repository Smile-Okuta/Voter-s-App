package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.user.models.BallotModel;
import com.vote.Voter.sApp.user.models.CandidateModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteRequest {
    private String pvcNumber;
    private BallotModel ballot;
    private CandidateModel candidate;
}
