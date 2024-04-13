package com.vote.Voter.sApp.pvc.models;

import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int houseNumber;
    private String streetName;
    @Enumerated(EnumType.STRING)
    private LgaName lgaName;
    @Enumerated(EnumType.STRING)
    private StateName stateName;

}
