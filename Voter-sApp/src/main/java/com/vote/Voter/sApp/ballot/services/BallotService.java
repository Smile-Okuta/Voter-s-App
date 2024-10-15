package com.vote.Voter.sApp.ballot.services;

import com.vote.Voter.sApp.ballot.dto.request.CreateBallotRequest;
import com.vote.Voter.sApp.ballot.models.BallotModel;
import org.springframework.stereotype.Service;


public interface BallotService {

    BallotModel createBallot (CreateBallotRequest ballotRequest);
    BallotModel updateBallot (CreateBallotRequest updateBallotRequest, Long id);
}
