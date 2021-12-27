package com.pb.dn131081gmm.hw13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Warehouse {
    String status = "empty";
    static List<Integer> dataBaseOfGoods = new ArrayList<>();
    Random genCod = new Random();

    synchronized void puting(boolean startStop) {
        if (!startStop) { //если аргумент startStop будет Не tru
            status = "full";
            notify();
            return;
        }
        if (!dataBaseOfGoods.isEmpty() || dataBaseOfGoods.size() < 5) {
            System.out.println("Загружаем товары на склад.\n");
            while (dataBaseOfGoods.size() < 5) {
                dataBaseOfGoods.add(genCod.nextInt(1001)); // генерируем код товара и добавляем его в список
                //if (dataBaseOfGoods != null && !dataBaseOfGoods.isEmpty()) {
                System.out.println("На склад положили товар: " + dataBaseOfGoods.get(dataBaseOfGoods.size() - 1));
                //}
            }
            status = "full";
            notify();
            while (!status.equals("empty")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Прерывание потока");
                }
            }
        } else {
            System.out.println("На складе перезагруженость товарами. ожидаем вывоза.");
            status = "full";
            notify();
            while (!status.equals("empty")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Прерывание потока");
                }
            }
        }
    }

    synchronized void taking(boolean startStop) {
        if (!startStop) { //если аргумент startStop будет Не tru
            status = "empty";
            notify();
            return;
        }
        while (!status.equals("full")) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Прерывание потока");
            }
        }
        if (dataBaseOfGoods.size() >= 5) {
            System.out.println("\nЗабираем товары со склада:");
            Iterator<Integer> iter = dataBaseOfGoods.iterator();
            while (iter.hasNext()) {
                System.out.println("Забрали со склада товар под кодом " + iter.next());
                iter.remove();
            }
            status = "empty";
            notify();
            while (!status.equals("full")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Прерывание потока");
                }
            }
        }
    }
}
