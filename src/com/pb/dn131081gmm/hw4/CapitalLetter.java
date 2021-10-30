package com.pb.dn131081gmm.hw4;

import java.util.Scanner;

public class CapitalLetter {
    String upFirstLetter(String str) {
        char[] arrayWithMyString;
        StringBuilder bldNewStr = new StringBuilder();
        arrayWithMyString = str.toCharArray();
        for (int i = 0; i < arrayWithMyString.length; i++) {
            if (i > 0 && !Character.isLetter(arrayWithMyString[i])) {
                bldNewStr.append(arrayWithMyString[i]);
            } else {
                if (i > 0 && Character.isLowerCase(arrayWithMyString[i]) && !Character.isLetterOrDigit(arrayWithMyString[i - 1])) {
                    bldNewStr.append(Character.toUpperCase(arrayWithMyString[i]));
                } else {
                    if (i > 0) {
                        bldNewStr.append(arrayWithMyString[i]);
                    } else {
                        if (i == 0 && !Character.isLetter(arrayWithMyString[i])) {
                            bldNewStr.append(arrayWithMyString[i]);
                        } else {
                            if (i == 0 && Character.isLowerCase(arrayWithMyString[i])) {
                                bldNewStr.append(Character.toUpperCase(arrayWithMyString[i]));
                            } else {
                                if (i == 0) {
                                    bldNewStr.append(arrayWithMyString[i]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return bldNewStr.toString();
    }

    public static void main(String[] args) {
        String myString;
        CapitalLetter caplLetter = new CapitalLetter();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите сроку: ");
        myString = in.nextLine();
        System.out.println("Измененная строка: " + caplLetter.upFirstLetter(myString));

    }
}

