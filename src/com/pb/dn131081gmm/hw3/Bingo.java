package com.pb.dn131081gmm.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        int randNumber, myNumber = 0, chek = 0, count = 0;
        String chekEnd;
        Random randNam = new Random();
        Scanner in = new Scanner(System.in);
        Bingo bin = new Bingo();
        randNumber = randNam.nextInt(101);
        System.out.println(randNumber); //Вывод для наглядности(теста дз). При необхотимости можно закомментарить
        while (true) {
            if (chek == 0) {
                if ((count % 3 == 0) && (count != 0)) {
                    if (count == 3)
                        System.out.println("Вы уже сделали " + count + " попытоки");
                    else
                        System.out.println("Вы уже сделали " + count + " попыток");
                    System.out.print("Если есть желание продолжить введите Y, если хотете прекратить введите, что угодно: ");
                    chekEnd = in.next();
                    if (('Y' == chekEnd.charAt(0)) || ('y' == chekEnd.charAt(0))) {
                        System.out.println("Продолжим");
                    } else {
                        System.out.println("Сгенерированное число было равно " + randNumber);
                        break;
                    }
                }
                System.out.print("Введите число от 0 до 100 включительно: ");
                myNumber = in.nextInt();
                chek = bin.checkInterval(myNumber);
                count++;
            } else {
                if (randNumber == myNumber) {
                    System.out.println("Браво." + "\n" + "Вы угадали с " + count + "й попытки");
                    break;
                } else {
                    chek = 0;
                    System.out.println("К сожалению вы не угадали");
                }
            }

        }
    }

    int checkInterval(int num) {
        if ((num < 0) || (num > 100)) {
            System.out.println("Вы ввели число которое находится за пределами указаного диапазона");
            return 0;
        } else return 1;
    }
}
