package com.vote.Voter.sApp.pvc.dto.request;

import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePvc {
    private String bvn;
    private LgaName localGovUnit;
    private StateName stateUnit;
}