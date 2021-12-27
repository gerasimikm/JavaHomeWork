package com.pb.dn131081gmm.hw13;


public class MyThread implements Runnable {
    Thread thrd;
    Warehouse putAndTakeGoods;

    MyThread(String name, Warehouse wh) {  //конструктор с названием потока name и который будет запскать поток при создании обьекта MyThread
        thrd = new Thread(this, name);
        putAndTakeGoods = wh;
        thrd.start(); //старт потока
    }

    @Override
    public void run() {
        //будем ложить и забирать товар со склада 6ть дней(раз)
        //в условии - проверка текущего процесса. Перевод первой буквый в верхний регистр остальных в нижний
        if ((thrd.getName().substring(0, 1).toUpperCase() + thrd.getName().substring(1).toLowerCase()).equals("Puting")) {
            for (int i = 0; i < 6; i++){
                Days.getDay(i+1);
                putAndTakeGoods.puting(true);
            }
            putAndTakeGoods.puting(false);

        } else if ((thrd.getName().substring(0, 1).toUpperCase() + thrd.getName().substring(1).toLowerCase()).equals("Taking")) {
            for (int i = 0; i < 6; i++){
                putAndTakeGoods.taking(true);
            }
            putAndTakeGoods.taking(false);
        }
    }
}

