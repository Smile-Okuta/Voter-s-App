package com.vote.Voter.sApp.pvc.enums;

import lombok.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
//@Getter
public enum StateName  {
    ABIA("AB", 12),
    ABUJA("FCT", 11),
    ADAMAWA("AD", 10),
    AKWA_IBOM("AK", 1),
    ANAMBRA("AN", 2),
    BAUCHI("BA", 3),
    BAYELSA("BY", 7),
    BENUE("BE", 8),
    BORNO("BO",9),
    CROSS_RIVER("CR", 32),
    DELTA("DE", 33),
    EBOYIN("EB", 34),
    EDO("ED", 15),
    EKITI("EK", 16),
    ENUGU("EN", 17),
    GOMBE("GO", 20),
    IMO("IMO", 21),
    JIGAWA("JI",22),
    KADUNA("KD", 23),
    KANO("KN",24),
    KASTINA("KS", 30),
    KEBBI("KE",31),
    KOGI("KO", 35),
    KWARA("KW", 36),
    LAGOS("LA", 13),
    NASARAWA("NA", 14),
    NIGER("NI", 19),
    OGUN("OG", 25),
    ONDO("ON", 26),
    OSUN("OS", 27),
    OYO("OY",4),
    PLATEAU("PL", 5),
    RIVERS("RI", 6),
    SOKOTO("SO", 13),
    TARABA("TA", 14),
    YOBE("YO", 18),
    ZAMFARA("ZA", 28);


    private final String value;
    private final  int code;
    private StateName(String value, int code){
        this.value = value;
        this.code = code;
    }
    public String getValue(){
        return this.value + this.code;
    }



}
