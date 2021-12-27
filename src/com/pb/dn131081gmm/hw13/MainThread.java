package com.pb.dn131081gmm.hw13;

public class MainThread {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        MyThread mt1 = new MyThread("Puting", warehouse);
        MyThread mt2 = new MyThread("Taking", warehouse);
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока");;
        }
        //System.out.println(dataBaseOfGoods.size());
    }
}
