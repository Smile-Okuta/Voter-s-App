package com.vote.Voter.sApp.user.repositories;


import com.vote.Voter.sApp.user.enums.UserRole;
import com.vote.Voter.sApp.user.models.CandidateModel;
import com.vote.Voter.sApp.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
    String findBy (String password);
    Optional<UserModel> findByPvc(String pvc);
    UserModel findById();
    boolean existsByPvc(String pvc);
}

