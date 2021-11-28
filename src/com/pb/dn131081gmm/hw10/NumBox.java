package com.pb.dn131081gmm.hw10;

public class NumBox<T extends Number> {
    T[] arrayNumBox;
    int lengthArray;

    NumBox(int lengthArray) {
        this.lengthArray = lengthArray;
        arrayNumBox = (T[]) new Number[lengthArray];
    }

    public void add(T num) throws Exception {
        for (int i = 0, flag = 0; i < lengthArray && flag != 1; i++) {
            if (arrayNumBox[i] == null) {
                arrayNumBox[i] = num;
                flag++;
            } else {
                try {
                    if (i == (lengthArray - 1)) {
                        throw new Exception("Массив заполнен, добавить новый елемнт " + num.getClass().getSimpleName() + "(" + num.toString() + ")" + " неудалось");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    //Метод возвращает ссылку на обьект, которая  хранится в массиве под индексом index
    public T get(int index) {
        return arrayNumBox[index];
    }

    public int length() {
        int count = 0;
        for (Number arrayElements : arrayNumBox) {
            if (arrayElements != null) {
                count++;
            }
        }
        return count;
    }

    //Метот вычисляет среднее арифметическое значение обьектов(не null) элементов массива
    public double average() {
        double sum = 0;
        int countNum = 0;
        for (Number arrayElements : arrayNumBox) {
            if (arrayElements != null) {
                sum += arrayElements.doubleValue();
                countNum++; //подсчет не пустых ссылок елемнтов массива
            }
        }
        return sum / countNum;
    }

    public double sum() {
        double sum = 0;
        for (Number arrayElements : arrayNumBox) {
            if (arrayElements != null) {
                sum += arrayElements.doubleValue();
            }
        }
        return sum;
    }

    //метод возвращает обьетк масива имеющий наибольшее значение
    public T max() {
        double maxEl = 0;
        int indexMax = 0;
        T Ob = null;
        for (int j = 0; j < arrayNumBox.length; j++) {
            if (arrayNumBox[j].doubleValue() > maxEl) {
                maxEl = arrayNumBox[j].doubleValue();
                indexMax = j;
            }
            Ob = arrayNumBox[indexMax];
        }
        return Ob;
    }
}
