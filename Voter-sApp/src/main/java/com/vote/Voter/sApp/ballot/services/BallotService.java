package com.vote.Voter.sApp.ballot.services;

import com.vote.Voter.sApp.ballot.dto.request.CreateBallotRequest;
import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.ballot.dto.request.ViewBallotRequest;

import java.util.List;


public interface BallotService {

    BallotModel createBallot (CreateBallotRequest ballotRequest);
    BallotModel updateBallot (CreateBallotRequest updateBallotRequest, Long id);
    List<BallotModel> viewAvailableBallot(ViewBallotRequest userId);
}
