package com.numToWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Перевод числа в цифровой записи в строковую. Например 134345 будет "сто тридцать четыре тысячи триста сорок пять".
        * Учесть склонения - разница в окончаниях (к примеру, две и два).


        Алгоритм должен работать для сколько угодно большого числа, соответственно, значения степеней - миллион, тысяча, миллиард
        и т.д. - должны браться из справочника, к примеру, текстового файла.

        Обязательно создать Data Driven Test
        (я, как пользователь, должен иметь возможность ввести множество наборов 1.число 2.правильный эталонный результат,
        тест самостоятельно проверяет все наборы и говорит, что неверное), который доказывает, что Ваш алгоритм работает правильно.
        Использовать JUnit.

        По возможности, применить ООП.
*/
public class NumWord {
    public static void main(String[] args) throws FileNotFoundException {
        NumberToWords numberToWords = new NumberToWords();
        Scanner s = new Scanner(new File("NumbersForTesting.txt"));
        while (s.hasNext()) {
            System.out.println(numberToWords.translate(s.nextLine()));
        }
    }
}
