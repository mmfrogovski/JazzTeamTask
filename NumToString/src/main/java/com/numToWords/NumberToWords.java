package com.numToWords;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class NumberToWords {

    public String translate(String number){
        return isNumeric(number) ? getStringNumberValue(number) : "Not correct input";
    }

    public String getStringNumberValue(String number) {
        number = deleteZerosInStart(number);
        return number.length() == 1 ?
                number.equals("0") ?
                        "нуль"
                        : Numbers.defineNumber(Character.getNumericValue(number.charAt(0))).nominative
                : splitNumber(number).replaceAll("\\s+", " ").trim();
    }

    public String splitNumber(String number) {
        int size = number.length();
        List<Integer> currNumbers = new ArrayList<>();
        StringBuilder finalNumber = new StringBuilder();
        int count = 0;
        int power = 0;
        for (int i = size - 1; 0 <= i; i--) {
            currNumbers.add((int) (Character.getNumericValue(number.charAt(i)) * pow(10, count)));
            count++;
            Numbers tmp;
            tmp = power + 1000 > 1063 ? Numbers.llion : Numbers.defineNumber(1000 + power);
            if (count == 3 || i == 0) {
                if (size < 2) {
                    finalNumber.insert(0, getDozens(0, currNumbers.get(0), tmp));
                } else if (size < 3) {
                    finalNumber.insert(0, getDozens(currNumbers.get(1), currNumbers.get(0), tmp));
                } else {
                    if (isZeros(currNumbers)) {
                        finalNumber.insert(0, "");
                    } else {

                        finalNumber
                                .insert(0, getDozens(currNumbers.get(1), currNumbers.get(0), tmp))
                                .insert(0, getHundreds(currNumbers.get(2)));
                    }
                    power += 3;
                    size -= 3;
                }
                currNumbers.clear();
                count = 0;
            }
        }
        return finalNumber.toString();
    }


    public boolean isZeros(List<Integer> list) {
        for (Integer e : list) {
            if (e != 0) return false;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public String getHundreds(int part) {
        Numbers numbers;
        String stringValue;
        if (part < 500) {
            numbers = Numbers.defineNumber(part);
            stringValue = numbers.nominative + " ";
        } else {
            numbers = Numbers.defineNumber(part / 100);
            stringValue = numbers.nominative + "сот ";
        }
        return stringValue;
    }

    public String deleteZerosInStart(String number) {
        if (number.startsWith("0") && number.length() != 1) {
            number = number.substring(1);
            number = deleteZerosInStart(number);
        }
        return number;
    }

    public String getDozens(int dozens, int units, Numbers power) {
        String stringValue;
        if (power.numValue > 1063) {
            power = Numbers.llion;
        }
        if (dozens == 10 && units != 0) {
            stringValue = constructNumber(Numbers.defineNumber(dozens),
                    units, power, defineCase(dozens, units), "надцать ");
        } else if (dozens == 10) {
            stringValue = Numbers.ten.nominative;
        } else if (dozens < 40) {
            stringValue = constructNumber(Numbers.defineNumber(dozens / 10),
                    units, power, defineCase(dozens, units), "дцать ");
        } else {
            stringValue = constructNumber(Numbers.defineNumber(dozens / 10),
                    units, power, defineCase(dozens, units), "десят ");
        }
        if (dozens == 40) {
            stringValue = constructNumber(Numbers.defineNumber(40),
                    units, power, defineCase(dozens, units), " ");
        }
        if (dozens == 90) {
            stringValue = constructNumber(Numbers.defineNumber(90),
                    units, power, defineCase(dozens, units), " ");
        }
        if (dozens < 10) {
            stringValue = constructNumber(Numbers.zero,
                    units, power, defineCase(dozens, units), " ");
        }
        return stringValue;
    }

    public String constructNumber(Numbers dozens, int units, Numbers power, int numCase, String ending) {
        String stringValue = "";
        if (numCase == 1) {
            stringValue = dozens.nominative + ending
                    + getUnitsWithCase(power, Numbers.defineNumber(units), dozens, numCase)
                    + " " + power.nominative + " ";
        } else if (numCase == 2) {
            stringValue = dozens.nominative + ending
                    + getUnitsWithCase(power, Numbers.defineNumber(units), dozens, numCase)
                    + " " + power.other + " ";
        } else if (numCase == 3) {
            if (ending.equals("надцать ")) {
                stringValue = getUnitsWithCase(power, Numbers.defineNumber(units), dozens, numCase)
                        + ending + power.plural + " ";
            } else {
                stringValue = dozens.nominative + ending
                        + getUnitsWithCase(power, Numbers.defineNumber(units), dozens, numCase)
                        + " " + power.plural + " ";
            }
        }
        return stringValue;
    }

    public int defineCase(int dozens, int units) {
        int numCase;
        if (units == 1 && dozens != 10) {
            numCase = 1;
        } else if (units >= 2 && units <= 4 && dozens != 10) {
            numCase = 2;
        } else {
            numCase = 3;
        }
        return numCase;
    }

    public String getUnitsWithCase(Numbers power, Numbers units, Numbers dozens, int numCase) {
        if (power == Numbers.oneThousand && numCase == 1) {
            return units.plural;
        } else if (numCase == 1) {
            return units.nominative;
        } else if (power == Numbers.oneThousand && units.numValue == 2) {
            return units.other;
        } else if (numCase == 2) {
            return units.plural;
        } else if ((dozens.numValue == 10) && (numCase == 3)) {
            return units.other;
        } else if (power == Numbers.oneThousand && numCase == 3) {
            return units.nominative;
        } else if (numCase == 3) {
            return units.plural;
        }
        return "";
    }
}
