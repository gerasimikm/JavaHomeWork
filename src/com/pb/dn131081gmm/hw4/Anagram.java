package com.pb.dn131081gmm.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    static String checkAnagrams(String str1, String str2) {
        str1 = str1.toLowerCase(); //переводим страку в нижний регистр
        str2 = str2.toLowerCase();
        str1 = str1.replaceAll("[^\\da-zа-яё]", ""); // убираем из строки все кроме букв и цифр.
        str2 = str2.replaceAll("[^\\da-zа-яё]", "");
        char[] cAnagram1 = str1.toCharArray(); //трансформируем строку в масив символов
        char[] cAnagram2 = str2.toCharArray();
        Arrays.sort(cAnagram1);
        Arrays.sort(cAnagram2);
        if ((new String(cAnagram1)).equals(new String(cAnagram2)))
            return "Эти строки являются анаграммами";
        else
            return "Это не анаграммы";
    }

    public static void main(String[] args) {
        String sAnagram1, sAnagram2;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку1: ");
        sAnagram1 = in.nextLine();
        System.out.print("Введите строку2: ");
        sAnagram2 = in.nextLine();

        System.out.println(checkAnagrams(sAnagram1, sAnagram2));
    }
}

//sAnagram1 = "Аз есмь строка, живу я, мерой остр";
//sAnagram2 = "За семь морей ростка я вижу рост";
