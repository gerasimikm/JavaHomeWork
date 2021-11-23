package com.pb.dn131081gmm.hw9;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        FileNumbers fn = new FileNumbers();
        int numbersString = 0;
        System.out.print("Укажите количество строк которое будем записывать в файл: ");
        if (in.hasNextInt()) {
            numbersString = in.nextInt();
            if ((numbersString > 0) && numbersString < 100) {
                fn.createNumbersFile(numbersString);
                fn.createOddNumbersFile();
            }
            if (numbersString < 0)
                System.out.println("Введенное число меньше 0 - в файл ничего не запишется");
            else if (numbersString > 100) {
                System.out.println("Введенное число довольно большое ограничемся 100й строк");
                numbersString = 100;
                fn.createNumbersFile(numbersString);
                fn.createOddNumbersFile();
            }
        } else {
            System.out.println("Программа ожидает целое ");
        }


    }


    // Методт createNumbersFile создает файл numbers.txt и заполняет его числами. по 10 чисел в строке
    public void createNumbersFile(int countStr) throws IOException {
        File f1 = new File("numbers.txt");
        if(f1.exists()){
            if (f1.delete()) {                                                                 //Удаляем файл numbers.txt
                System.out.println("numbers.txt файл был удален с корневой папки проекта");
            } else System.out.println("Файл numbers.txt не доступен к удалению");
            if (f1.createNewFile()) {
                System.out.println("numbers.txt создан в корне JavaHomeWork");
            } else {
                System.out.println("В корне JavaHomeWork уже судествует файл с названием numbers.txt");
            }
        } else{
            if (f1.createNewFile()) {
                System.out.println("numbers.txt создан в корне JavaHomeWork");
            } else {
                System.out.println("файл numbers.txt не удалось создать");
            }

        }
            System.out.println("В корне JavaHomeWork уже судествует файл с названием numbers.txt");

        FileWriter writer = null;
        try {
            writer = new FileWriter("numbers.txt", true); //обьект класса FileWriter с возможностью дописывать файл
            for (int i = 0; i < countStr; i++) {
                writer.write(getStr() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // метод генерит строку чисел от 0 до 99 включительно
    public String getStr() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(100));
            sb.append(" ");
        }
        return new String(sb);
    }


    //Метод createOddNumbersFile создает и записывает модифицированый файл f1 в f2
    public void createOddNumbersFile() throws IOException {

        File f2 = new File("odd-numbers.txt");

        if (f2.delete()) {                                                                  //Удаляем файл odd-numbers.txt
            System.out.println("odd-numbers.txt файл был удален с корневой папки проекта");
        } else System.out.println("Файл odd-numbers.txt не был найден в корневой папке проекта");
        if (f2.createNewFile()) {
            System.out.println("odd-numbers.txt создан в корне JavaHomeWork");
        } else {
            System.out.println("В корне JavaHomeWork уже судествует файл с названием odd-numbers.txt");
        }
        FileWriter wrt = null;
        //File f2 = new File("odd-numbers.txt");
        String str = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            wrt = new FileWriter(f2, true); //обьект класса FileWriter с возможностью дописывать файл
            fileReader = new FileReader("numbers.txt");
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            str = bufferedReader.readLine();
            while (str != null) {
                try {
                    wrt.write(modifyStr(str) + "\n");
                    str = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                wrt.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //метод modifyStr получает строку чисел и заменяет четные числа на 0
    public String modifyStr(String line) {
        String[] strArray = null;
        StringBuilder strBild = new StringBuilder(); //обьет для построения новой строки
        strArray = line.split(" ");   //масив строк созданых на основе line - разделитель - пробел
        for (int i = 0; i < strArray.length; i++) {
            if ((Integer.parseInt(strArray[i])) % 2 == 0) { //явное преобразование строки в число и проверка его на четность
                if (i == (strArray.length - 1))
                    strBild.append("0");                    //добавляем в строку "0"
                else
                    strBild.append("0 ");                    //добавляем в строку "0 "
            } else {
                if (i == (strArray.length - 1))
                    strBild.append(strArray[i]);  //добавляем в строку Нечетное число(строку)
                else
                    strBild.append(strArray[i] + " ");  //добавляем в строку Нечетное число(строку) + пробел
            }
        }
        return strBild.toString();

    }
}

