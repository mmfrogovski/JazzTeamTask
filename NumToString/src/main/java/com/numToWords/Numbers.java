package com.numToWords;

import java.util.Arrays;

public enum Numbers {
    zero("", "", "", 0),
    one("один", "одна", "один", 1),
    two("два", "два", "две", 2),
    three("три", "три", "три", 3),
    four("четыре", "четыре", "четыр", 4),
    five("пять", "пять", "пят", 5),
    six("шесть", "шесть", "шест", 6),
    seven("семь", "семь", "сем", 7),
    eight("восемь", "восемь", "восем", 8),
    nine("девять", "девять", "девят", 9),
    ten("десять", "десять", "десять", 10),
    forty("сорок", "сорок", "сорок", 40),
    oneHundred("сто", "сто", "сто", 100),
    twoHundred("двести", "двести", "двести", 200),
    threeHundred("триста", "триста", "триста", 300),
    fourHundred("четыреста", "четыриста", "четыреста", 400),
    ninety("девяносто", "девяносто", "девяносто", 90),
    oneThousand("тысяча", "тысяч", "тысячи", 1003),
    million("миллион", "миллионов", "миллиона", 1006),
    milliard("миллиард", "миллиардов", "миллиарда", 1009),
    trillion("триллион", "триллионов", "триллиона", 1012),
    quadrillion("квадриллион", "квадриллионов", "квадриллиона", 1015),
    quintillion("квинтиллион", "квинтиллионов", "квинтиллиона", 1018),
    sextillion("секстиллион", "секстиллионов", "секстиллиона", 1021),
    septillion("септиллион", "септиллионов", "септиллиона", 1024),
    octillion("октиллион", "октиллионов", "октиллиона", 1027),
    nonillion("нониллион", "нониллионов", "нониллиона", 1030),
    decillion("дециллион", "дециллионов", "дециллиона", 1033),
    undecillion("ундециллион", "ундециллионов", "ундециллиона", 1036),
    duodecillion("дуодециллион", "дуодециллионов", "дуодециллиона", 1039),
    tredecillion("тредециллион", "тредециллионов", "тредециллиона", 1042),
    quattuordecillion("кваттуордециллион", "кваттуордециллионов", "кваттуордециллиона", 1045),
    quindecillion("квиндециллион", "квиндециллионов", "квиндециллиона", 1048),
    sexdecillion("сексдециллион", "сексдециллионов", "сексдециллиона", 1051),
    septendecillion("септдециллион", "септдециллионов", "септдециллиона", 1054),
    octodecillion("октодециллион", "октодециллионов", "октодециллиона", 1057),
    novemdecillion("новемдециллион", "новемдециллионов", "новемдециллиона", 1060),
    vigintillion("вигинтиллион", "вигинтиллионов", "вигинтиллиона", 1063),
    llion("...иллион", "...ллионов", "...ллиона", 1999);

    public final String nominative;
    public final String plural;
    public final String other;
    public final int numValue;

    Numbers(String nominative, String plural, String other, int numValue) {
        this.nominative = nominative;
        this.plural = plural;
        this.other = other;
        this.numValue = numValue;
    }

    public static Numbers defineNumber(int intValue){
        return Arrays.stream(Numbers.values())
                .filter(num -> num.numValue == intValue)
                .findAny()
                .orElse(Numbers.zero);
    }

}
