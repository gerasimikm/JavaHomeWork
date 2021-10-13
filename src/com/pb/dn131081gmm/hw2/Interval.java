package com.pb.dn131081gmm.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число от 0 до 100 включительно" + "\n" + "number = ");
        int number = in.nextInt();
        if (number < 0 || number > 100) {
            System.out.println("Введенное число не попадает в указаный диапазон [0...100]");
        } else if (number <= 14) {
            System.out.println("Введенное число находится в диапазоне [0...14]");
        }
        if (number >= 15 && number <= 35) {
            System.out.println("Введенное число находится в диапазоне [15...35]");
        }
        if (number >= 36 && number <= 50) {
            System.out.println("Введенное число находится в диапазоне [36...50]");
        }
        if (number >= 51) {
            System.out.println("Введенное число находится в диапазоне [51...100]");
        }


    }
}
