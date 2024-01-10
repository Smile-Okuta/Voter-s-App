package com.vote.Voter.sApp.admin.repositories;

import com.vote.Voter.sApp.admin.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Long>{

}
