package com.vote.Voter.sApp.ballot.servicesImpl;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.ballot.services.BallotService;
import com.vote.Voter.sApp.user.dto.request.ViewBallotRequest;
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
    public List<BallotModel> getAvailableBallots(String location) {
        List<BallotModel> ballotLocation = new ArrayList<>();
        for (BallotModel ballot : availableBallots){
            if (ballot.getLocation().equals(location)){
                ballotLocation.add(ballot);
            }
        }
        return ballotLocation;
    }

    @Override
    public List<BallotModel> getAvailableBallots(ViewBallotRequest ballotLocation) {
        return null;
    }
}
