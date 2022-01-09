package com.pb.dn131081gmm.hw14.client;

import com.pb.dn131081gmm.hw14.network.TCPConnection;
import com.pb.dn131081gmm.hw14.network.TCPConnectionListener;

import java.io.IOException;
import java.util.Scanner;

public class Clnt implements TCPConnectionListener {
    public static final String IP_ADDR = "127.0.0.1";
    public static final int PORT = 50055;
    private TCPConnection connection;
    private String nikName;

    private Clnt(String nn) {
        nikName = nn;
        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Thread xClientThread = new Thread(new Runnable() {

            @Override
            public void run() {

                String str = "";
                Scanner in = new Scanner(System.in);
                System.out.print("Ваш ник: ");
                String clientName = in.nextLine();
                Clnt clnt = new Clnt(clientName);
                while (true) {
                    try {
                        //System.out.print(clnt.nikName + ": ");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        str = in.nextLine();
                        if ((str.equalsIgnoreCase("bay"))) {
                            clnt.connection.desconnect();
                            return;
                        }
                        clnt.connection.sendString(clnt.nikName + ": " + str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });
        xClientThread.start();

    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        System.out.println("Connection ready");
    }

    @Override
    public void onResiveString(TCPConnection tcpConnection, String str) {
        System.out.print(str + "\n");
    }

    @Override
    public void onDisconect(TCPConnection tcpConnection) {
        System.out.println("Connection close.");
    }

    @Override
    public void onExeption(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exeption " + e);

    }
}
