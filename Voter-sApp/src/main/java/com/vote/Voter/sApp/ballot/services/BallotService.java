package com.vote.Voter.sApp.ballot.services;

import com.vote.Voter.sApp.ballot.dto.request.ViewBallotRequest;
import com.vote.Voter.sApp.ballot.models.BallotModel;

import java.util.List;

public interface BallotService {
    List<BallotModel> getAvailableBallots(ViewBallotRequest userLocation);
}
