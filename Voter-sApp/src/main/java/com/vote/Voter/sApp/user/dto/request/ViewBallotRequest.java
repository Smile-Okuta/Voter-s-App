package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.ballot.enums.BallotTitle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewBallotRequest {
    private BallotTitle ballotTitle;
}
