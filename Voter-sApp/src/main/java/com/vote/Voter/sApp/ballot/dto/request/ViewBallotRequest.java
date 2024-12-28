package com.vote.Voter.sApp.ballot.dto.request;
//
//import com.vote.Voter.sApp.ballot.enums.BallotTitle;
//import com.vote.Voter.sApp.user.models.BallotModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewBallotRequest {
    private String pvc;
//    private BallotTitle ballotTitle;
//    private List<BallotModel> location;
}
