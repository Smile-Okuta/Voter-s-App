package com.vote.Voter.sApp.user.repositories;

import com.vote.Voter.sApp.user.models.UserModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Id> {
    Optional<UserModel> findByPvc(String pvc);

    Boolean existsByPvc(String pvc);
}

