package com.vote.Voter.sApp.ballot.models;

import com.vote.Voter.sApp.ballot.enums.BallotStatus;
import com.vote.Voter.sApp.user.models.CandidateModel;
import com.vote.Voter.sApp.user.models.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BallotModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Ballot title is required")
        private String title;

        @NotBlank(message = "Ballot description is required")
        @Size(max = 2500)
        private String description;

        @NotBlank(message = "Ballot status is required")
        @Enumerated(EnumType.STRING)
        private BallotStatus ballotStatus;

        @OneToMany(mappedBy = "Ballot", cascade = CascadeType.ALL)
        private List<CandidateModel> candidate;

        @ManyToOne
        private UserModel userModel;

        @NotBlank(message = "start date is required")
        @FutureOrPresent
        private LocalDateTime startDate;

        @Future
        @NotBlank(message = "End date is required")
        private LocalDateTime endDate;
        
}
