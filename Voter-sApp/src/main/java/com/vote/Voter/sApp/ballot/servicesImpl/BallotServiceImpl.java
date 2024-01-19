package com.vote.Voter.sApp.ballot.servicesImpl;

import com.vote.Voter.sApp.ballot.dto.request.ViewBallotRequest;
import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.ballot.services.BallotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BallotServiceImpl implements BallotService {
private final List<BallotModel> availableBallots;

    public BallotServiceImpl(List<BallotModel> availableBallots) {
        this.availableBallots = availableBallots;

    }

    @Override
    public List<BallotModel> getAvailableBallots(ViewBallotRequest userLocation) {
        List<BallotModel> ballotLocation = new ArrayList<>();
        for (BallotModel ballot : availableBallots){
            if (ballot.getLocation().equals(userLocation.getLocation())){
                ballotLocation.add(ballot);
            }
        }
        return ballotLocation;
    }
}
