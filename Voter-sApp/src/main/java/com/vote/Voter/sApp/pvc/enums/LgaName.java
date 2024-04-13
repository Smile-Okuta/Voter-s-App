package com.vote.Voter.sApp.pvc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



public enum LgaName {
    SHOMOLU (12),
    BARIGA (10),
    ALIMOSHO(2),
    YABA(13),
    AJEROMI_IFELODUN (20),
    KOSOFE(14),
    MUSHIN(1),
    OSHODI(8),
    OJO(3),
    IKORODU(11),
    SURULERE(17),
    AGEGE(6),
    AMUWO_ODOFIN(7),
    LAGOS_MAINLAND(19),
    IKEJA(16),
    ETI_OSA(4),
    EPE(18),
    APAPA(5),
    BADAGRY(15),
    IBEJU_LEKKI(9),


    ABA_NORTH(21),
    ABA_SOUTH(22),
    AROCHUKWU(23),
    BENDE(24),
    IKWUANO(25),
    ISIALA_NGWA_NORTH(26),
    ISIALA_NGWA_SOUTH(27),
    ISUIKWUATO(28),
    OBI_NGWA(29),
    OHAFIA(30),
    OSISIOMA_NGWA(31),
    UGWUNAGBO(32),
    UKWA_EAST(33),
    UKWA_WEST(34),
    UMUAHIA_NORTH(35),
    UMUAHIA_SOUTH(36),


    ABUJA_MUNICIPAL(37),
    BWARI(38),
    GWAGWALADA(39),
    KUJE(40),
    KWALI(41),
    ABAJI(42),


    DEMSA(43),
    FUFURE(44),
    GANYE(45),
    GIREI(46),
    GOMBI(47),
    GUYUK(48),
    HONG(49),
    JADA(50),
    LAMURDE(51),
    MADAGALI(52),
    MAIHA(53),
    MAYO_BELWA(54),
    MICHIKA(55),
    MUBI_NORTH(56),
    MUBI_SOUTH(57),
    NUMAN(58),
    SHELLENG(59),
    SONG(60),
    TOUNGO(61),
    YOLA_NORTH(62),
    YOLA_SOUTH(63),


    ABAK(55),
    EASTERN_OBOLO(56),
    EKET(57),
    ESIT_EKET(58),
    ESSIEN_UDIM(59),
    ETIM_EKPO(60),
    ETINAN(61),
    IBENO(62),
    IBESIKPO_ASUTAN(63),
    IBIONO_IBOM(64),
    IKA(65),
    IKONO(66),
    IKOT_ABASI(67),
    IKOT_EKPENE(68),
    INI(69),
    ITU(70),
    MBO(71),
    MKPAT_ENIN(72),
    NSIT_ATAI(73),
    NSIT_IBOM(74),
    NSIT_UBIUM(75),
    OBOT_AKARA(76),
    OKOBO(77),
    ONNA(78),
    ORON(79),
    ORUK_ANAM(80),
    UDUNG_UKO(81),
    UKANAFUN(82),
    URUAN(83),
    URUE_OFFONG_ORUKO(84),
    UYO(85),


    AGUATA(99),
    ANAMBRA_EAST(97),
    ANAMBRA_WEST(100),
    ANAOCHA(104),
    AWKA_NORTH(91),
    AWKA_SOUTH(105),
    AYAMELUM(107),
    DUNUKOFIA(102),
    EKWUSIGO(93),
    IDEMILI_NORTH(88),
    IDEMILI_SOUTH(106),
    IHIALA(100),
    NJIKOKA(87),
    NNEWI_NORTH(96),
    NNEWI_SOUTH(94),
    OGBARU(103),
    ONITSHA_NORTH(89),
    ONITSHA_SOUTH(101),
    ORUMBA_NORTH(95),
    ORUMBA_SOUTH(108),
    OYI(98),


    ALKALERI(118),
    BAUCHI(123),
    BOGORO(117),
    DAMBAN(122),
    DARAZO(121),
    DASS(114),
    GAMAWA(127),
    GANJUWA(110),
    GIADE(128),
    ITAS_GADAU(113),
    JAMAARE(126),
    KATAGUM(111),
    KIRFI(120),
    MISAU(124),
    NINGI(112),
    SHIRA(115),
    TAFAWA_BALEWA(125),
    TORO(116),
    WARJI(109),
    ZAKI(119);


    private final int lgaCode;
    private LgaName(int lgaCode){
        this.lgaCode = lgaCode;
    }
    private  int getLgaCode(){
        return this.lgaCode;
    }
}
