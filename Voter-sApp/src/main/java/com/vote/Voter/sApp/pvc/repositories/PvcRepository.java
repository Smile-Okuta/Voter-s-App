package com.vote.Voter.sApp.pvc.repositories;

import com.vote.Voter.sApp.pvc.models.PvcModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PvcRepository extends JpaRepository<PvcModel, Long>{

    boolean existsByNin(String nin);
    boolean existsByEmail(String email);
    PvcModel findByEmail(String email);

    PvcModel findOneByEmailAndPassword(String email, String password);
}
