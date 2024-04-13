package com.vote.Voter.sApp.ballot.services;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.user.dto.request.ViewBallotRequest;

import java.util.List;

public interface BallotService {
    List<BallotModel> getAvailableBallots(ViewBallotRequest ballotLocation);
    List<BallotModel> getAvailableBallots(String location);
}
