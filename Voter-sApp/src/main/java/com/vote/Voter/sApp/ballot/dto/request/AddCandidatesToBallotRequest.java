package com.vote.Voter.sApp.ballot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AddCandidatesToBallotRequest {
    private List<Long> candidateId;

}
