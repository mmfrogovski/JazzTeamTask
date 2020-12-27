package com.numToWords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class NumberToWordsTest {

    NumberToWords numberToWords = new NumberToWords();

    @Test
    void testForNumbersFromFiles() throws FileNotFoundException {
        Scanner numbersIn = new Scanner(new File("NumbersForTesting.txt"));
        Scanner resultIn = new Scanner(new File("Answers.txt"));
        while (numbersIn.hasNext()) {
            Assertions.assertEquals(numberToWords.translate(numbersIn.nextLine()), resultIn.nextLine());
        }
    }

    @Test
    void testForNumbersFromOneToTwenty() {
        String[] input = {"0001", "2", "3", "4", "05", "6", "7", "8", "9", "10",
                "11", "12", "13", "014", "15", "16", "17", "18", "19", "20"};
        String[] correctAnswers = {"один", "два", "три", "четыре",
                "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать",
                "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};
        for (int i = 0; i < input.length; i++) {
            Assertions.assertEquals(numberToWords.translate(input[i]), correctAnswers[i]);
        }
    }

    @Test
    void automationTestForDoubleDigitNumbers() {
        String[] input = {"65", "45", "91", "60", "84", "90", "55"};
        String[] correctAnswers = {"шестьдесят пять", "сорок пять", "девяносто один", "шестьдесят",
                "восемьдесят четыре", "девяносто", "пятьдесят пять"};
        for (int i = 0; i < input.length; i++) {
            Assertions.assertEquals(numberToWords.translate(input[i]), correctAnswers[i]);
        }
    }

    @Test
    void automationTestForThreeDigitNumbers() {
        String[] input = {"429", "358", "918", "125", "311", "100", "555"};
        String[] correctAnswers = {"четыреста двадцать девять", "триста пятьдесят восемь", "девятьсот восемнадцать",
                "сто двадцать пять", "триста одиннадцать", "сто", "пятьсот пятьдесят пять"};
        for (int i = 0; i < input.length; i++) {
            Assertions.assertEquals(numberToWords.translate(input[i]), correctAnswers[i]);
        }
    }

    @Test
    void automationTestForBigNumbers() {
        String[] input = {"11111111111100000000", "2222222222222222", "426525191930000112444"};
        String[] correctAnswers = {"одиннадцать квинтиллионов сто одиннадцать квадриллионов " +
                "сто одиннадцать триллионов сто одиннадцать миллиардов сто миллионов",
                "два квадриллиона двести двадцать два триллиона двести двадцать два миллиарда" +
                        " двести двадцать два миллиона двести двадцать две тысячи двести двадцать два",
                "четыреста двадцать шесть квинтиллионов пятьсот двадцать пять квадриллионов " +
                        "сто девяносто один триллион девятьсот тридцать миллиардов " +
                        "сто двенадцать тысяч четыреста сорок четыре"};
        for (int i = 0; i < input.length; i++) {
            Assertions.assertEquals(numberToWords.translate(input[i]), correctAnswers[i]);
        }
    }
}
