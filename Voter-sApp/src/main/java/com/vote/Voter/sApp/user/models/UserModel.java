package com.vote.Voter.sApp.user.models;

import com.vote.Voter.sApp.pvc.enums.Gender;
import com.vote.Voter.sApp.pvc.models.PvcModel;
import com.vote.Voter.sApp.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String password;
    private LocalDateTime createdAt;
    private  boolean isEnabled;
}
