package com.vote.Voter.sApp.ballot.servicesImpl;

import com.vote.Voter.sApp.ballot.dto.request.CreateBallotRequest;
import com.vote.Voter.sApp.ballot.enums.BallotStatus;
import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.ballot.repositories.BallotRepository;
import com.vote.Voter.sApp.ballot.services.BallotService;
import com.vote.Voter.sApp.user.enums.UserRole;
import com.vote.Voter.sApp.user.models.CandidateModel;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.CandidateRepository;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vote.Voter.sApp.user.enums.UserRole.ADMIN;
import static com.vote.Voter.sApp.user.enums.UserRole.CANDIDATE;

@Service
@RequiredArgsConstructor
public class BallotServiceImpl implements BallotService {
    UserRole role;
    BallotRepository ballotRepository;
    BallotStatus ballotStatus;
    UserRepository userRepository;
    CandidateRepository candidateRepository;
    UserRole userRole;


    @Override
    public BallotModel createBallot(CreateBallotRequest ballotRequest) {

        if (!role.equals(ADMIN)){
            throw new IllegalArgumentException("Only Admin can create a ballot");
        }

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
}
