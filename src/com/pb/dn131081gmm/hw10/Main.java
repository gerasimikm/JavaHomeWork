package com.pb.dn131081gmm.hw10;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int index = 0;
        Random random = new Random();
        NumBox<Integer> numBoxInteger = new NumBox<>(4);
        numBoxInteger.add(new Integer(-4));
        numBoxInteger.add(new Integer(2));
        numBoxInteger.add(new Integer(6));
        numBoxInteger.add(new Integer(8));
        numBoxInteger.add(new Integer(2));
        if (numBoxInteger.lengthArray > 0) {
            index = random.nextInt(numBoxInteger.lengthArray);
            System.out.println("average() -Среднее арифметическое занчение = " + numBoxInteger.average());
            System.out.println("length() - Количество не NULL значений маcсива = " + numBoxInteger.length());
            System.out.println("get(" + index + ") - Значение елемента массива под индэксом " + index + " = " + numBoxInteger.get(index));
            System.out.println("sum() - Сумма элементов маcсива = " + numBoxInteger.sum());
            System.out.println("max() - Максимальное значение среди елементов массива = " + numBoxInteger.max());
        }

    }
}
