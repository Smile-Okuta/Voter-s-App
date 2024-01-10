package com.vote.Voter.sApp.candidate.repositories;

import com.vote.Voter.sApp.candidate.models.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateModel, Long> {
}
