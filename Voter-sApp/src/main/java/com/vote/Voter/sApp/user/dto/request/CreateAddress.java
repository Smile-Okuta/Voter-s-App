package com.vote.Voter.sApp.user.dto.request;

import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddress {
    private int houseNumber;
    private String streetName;
    private LgaName lgaName;
    private StateName stateName;
}
