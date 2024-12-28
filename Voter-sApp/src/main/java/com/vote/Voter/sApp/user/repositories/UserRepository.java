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
//    Optional<UserModel> findByPvc(String pvc);
    Optional<UserModel> findByEmail(String email);
    Optional <UserModel> existsByEmail(String email);
    boolean existsByPassword(String password);
    String findBy (String password);

    List<UserModel> findAllById(String role);
    List<UserModel> findByIdAndRole(List<Long> id, String email);


    UserModel findById();
}

