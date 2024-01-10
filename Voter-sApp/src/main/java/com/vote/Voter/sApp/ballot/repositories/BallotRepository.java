package com.vote.Voter.sApp.ballot.repositories;

import com.vote.Voter.sApp.ballot.models.BallotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallotRepository extends JpaRepository<BallotModel, Long> {
}
