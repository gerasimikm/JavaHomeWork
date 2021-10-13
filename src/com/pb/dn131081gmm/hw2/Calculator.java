package com.pb.dn131081gmm.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1, operand2;
        String sing;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите значение для operand1:");
        System.out.print("operand1 = ");
        operand1 = in.nextInt();
        System.out.println("Введите значение для operand2:");
        System.out.print("operand2 = ");
        operand2 = in.nextInt();
        System.out.println("Какую арифметическую операцию вы хотите выполнить?");
        sing = in.next();
        char operation = sing.charAt(0);

        switch (operation) {
            case '+':
                System.out.println("operand1 + operand2 = " + (operand1 + operand2));
                break;
            case '-':
                System.out.println("operand1 - operand2 = " + (operand1 - operand2));
                break;
            case '*':
                System.out.println("operand1 * operand2 = " + (operand1 * operand2));
                break;
            case '/': {
                if (operand2 != 0) {
                    System.out.print("operand1/operand2 = " + (operand1 / operand2));
                    if (operand1 % operand2 != 0) {
                        System.out.println(", Остача = " + operand1 % operand2);
                    }
                } else
                    System.out.println("Делить на 0 нельзя!");
                break;
            }
            default:
                System.out.println("Калькулятору неведома указанная вами операция");
        }
    }

}

