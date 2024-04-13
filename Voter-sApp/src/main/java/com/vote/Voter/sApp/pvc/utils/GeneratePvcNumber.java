package com.vote.Voter.sApp.pvc.utils;

import com.vote.Voter.sApp.pvc.enums.LgaName;
import com.vote.Voter.sApp.pvc.enums.StateName;
import com.vote.Voter.sApp.pvc.models.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GeneratePvcNumber {
    static SecureRandom random = new SecureRandom();
   static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};



   private LgaName lgaCode;
   private StateName stateCode;


    public static String generateUserPvc(){
        char firstLetter = letters[random.nextInt(letters.length)];

        int firstNum = random.nextInt(10, 90);

        int secNum = 1 + random.nextInt(10);

        char secLetter = letters[random.nextInt(letters.length)];
        int thirdNum = random.nextInt(100, 999);

        return String.format("%d%s%d %s%d", secNum, firstLetter, firstNum, secLetter, thirdNum);

    }


    public final String officialCode(){
//       AddressModel addressModel = new AddressModel();
        return null;
    }

}
