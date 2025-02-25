package com.vote.Voter.sApp.pvc.models;

import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddressModel {
    @NotBlank
    private int houseNumber;

    @NotBlank
    private String streetName;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private LgaName lgaName;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private StateName stateName;


}
