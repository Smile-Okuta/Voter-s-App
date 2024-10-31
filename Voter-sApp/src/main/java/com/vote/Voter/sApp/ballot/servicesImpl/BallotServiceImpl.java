package com.vote.Voter.sApp.ballot.servicesImpl;

import com.vote.Voter.sApp.ballot.dto.request.CreateBallotRequest;
import com.vote.Voter.sApp.ballot.enums.BallotStatus;
import com.vote.Voter.sApp.ballot.exception.BallotNotFoundException;
import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.ballot.repositories.BallotRepository;
import com.vote.Voter.sApp.ballot.services.BallotService;
import com.vote.Voter.sApp.ballot.dto.request.ViewBallotRequest;
import com.vote.Voter.sApp.user.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vote.Voter.sApp.user.enums.UserRole.ADMIN;

@Service
@RequiredArgsConstructor
public class BallotServiceImpl implements BallotService {
    UserRole role;
    BallotRepository ballotRepository;


    @Override
    public BallotModel createBallot(CreateBallotRequest ballotRequest) {
        invalidUser();

      return newBallot(ballotRequest);
    }


    private BallotModel newBallot (CreateBallotRequest ballotRequest){
        BallotModel ballot = new BallotModel();
        ballot.setTitle(ballotRequest.getTitle());
        ballot.setDescription(ballotRequest.getDescription());
        ballot.setStartDate(ballotRequest.getStartDate());
        ballot.setEndDate(ballotRequest.getEndDate());
        ballot.setBallotStatus(BallotStatus.CLOSED);
        return ballotRepository.save(ballot);
    }


    @Override
    public BallotModel updateBallot(CreateBallotRequest updateBallotRequest, Long id) {

        invalidUser();

        return newUpdatedBallot(updateBallotRequest, id);
    }

    @Override
    public List<BallotModel> viewAvailableBallot(ViewBallotRequest userId) {
        return null;
    }

    private BallotModel newUpdatedBallot(CreateBallotRequest updateBallotRequest, Long id){

        return ballotRepository.findById(id).map(ballot -> {
            ballot.setTitle(updateBallotRequest.getTitle());
            ballot.setDescription(updateBallotRequest.getDescription());
            ballot.setStartDate(updateBallotRequest.getStartDate());
            ballot.setEndDate(updateBallotRequest.getEndDate());
            ballot.setBallotStatus(updateBallotRequest.getBallotStatus());
            return ballotRepository.save(ballot);
        }).orElseThrow(()-> new BallotNotFoundException("Ballot with the Id "+ id + " not found"));
    }
    private void invalidUser(){
        if (!role.equals(ADMIN)){
            throw new IllegalArgumentException("Only Admin can create a ballot");
        }

    }


}



