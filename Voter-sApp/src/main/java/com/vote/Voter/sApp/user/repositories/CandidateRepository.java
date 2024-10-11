package com.vote.Voter.sApp.user.repositories;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import com.vote.Voter.sApp.user.enums.UserRole;
import com.vote.Voter.sApp.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<BallotModel, Long> {


    List<UserModel> findAllById(UserRole role);


}
