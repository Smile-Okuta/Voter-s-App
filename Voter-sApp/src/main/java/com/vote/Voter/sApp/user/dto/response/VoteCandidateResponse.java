package com.vote.Voter.sApp.user.dto.response;

import com.vote.Voter.sApp.user.models.BallotModel;
import com.vote.Voter.sApp.user.models.CandidateModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteCandidateResponse {
    private BallotModel ballot;
    private CandidateModel candidate;
}
