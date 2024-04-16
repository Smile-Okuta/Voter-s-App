package com.vote.Voter.sApp.pvc.dto.request;

import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private int houseNumber;
    private String streetName;
    private LgaName lgaName;
    private StateName stateName;
}
