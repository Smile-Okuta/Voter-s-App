package com.vote.Voter.sApp.ballot.repositories;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BallotRepository extends JpaRepository<BallotModel, Long> {
}
