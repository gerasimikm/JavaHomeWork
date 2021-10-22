package com.pb.dn131081gmm.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] myArray = new int[10]; //изменение длинны массива не повлияет на работу класса
        int arrayLength = myArray.length, sumAllNanOfArray = 0, countPozitivNumbers = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Заполняем массив целыми числами. Размерность массива = " + myArray.length);
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("myArray[" + i + "] = ");
            myArray[i] = in.nextInt();
        }
        System.out.print("myArray = {");
        for (int j = 0; j < arrayLength; j++) {
            sumAllNanOfArray += myArray[j];
            if (myArray[j] >= 0) {
                countPozitivNumbers++;
            }
            System.out.print(myArray[j]);
            if (j < (arrayLength - 1))
                System.out.print(", ");
            else
                System.out.print("}\n");
        }

        System.out.print("Сумма всех членов массива равна = " + sumAllNanOfArray + "\n");
        System.out.print("Количество положительных членов массива равно = " + countPozitivNumbers + "\n");

        int iteration = (arrayLength - 1), buffer;
        for (int y = iteration; y > 0; y--) {
            for (int x = 0; x < y; x++) {
                if (myArray[x] > myArray[x + 1]) {
                    buffer = myArray[x];
                    myArray[x] = myArray[x + 1];
                    myArray[x + 1] = buffer;
                }
            }
        }
        System.out.print("Отсортированный myArray = {");
        for (int j = 0; j < arrayLength; j++) {
            System.out.print(myArray[j]);
            if (j < (arrayLength-1))
                System.out.print(", ");
            else
                System.out.print("}\n");
        }

    }
}