package com.vote.Voter.sApp.pvc.repositories;

import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.user.models.UserModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PvcRepository extends JpaRepository<PvcModel, Long>{

    PvcModel findByNin(String nin);

}
