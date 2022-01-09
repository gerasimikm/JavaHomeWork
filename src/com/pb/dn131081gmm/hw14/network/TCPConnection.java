package com.pb.dn131081gmm.hw14.network;

import java.io.*;
import java.net.Socket;

public class TCPConnection {
    private final Socket socket;
    private final Thread rxThread;
    private final BufferedReader buffIn;
    private final BufferedWriter buffOut;
    private final TCPConnectionListener eventListener;

    public TCPConnection(TCPConnectionListener eventListener, String ipAddr, int port) throws IOException {
        this(eventListener, new Socket(ipAddr, port));
    }

    public TCPConnection(TCPConnectionListener eventListener, Socket socket) throws IOException {
        this.eventListener = eventListener;
        this.socket = socket;
        buffIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        buffOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventListener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted()) {
                        eventListener.onResiveString(TCPConnection.this, buffIn.readLine());
                        // try { Thread.sleep(1000);} catch (InterruptedException e) { e.printStackTrace(); }
                    }
                } catch (IOException e) {
                    eventListener.onExeption(TCPConnection.this, e);
                } finally {
                    eventListener.onDisconect(TCPConnection.this);
                }
            }
        });
        rxThread.start();
    }

    //синхронизированый Метот отсылает сообщение
    public synchronized void sendString(String str) {
        try {
            buffOut.write(str + "\r\n");
            buffOut.flush();
        } catch (IOException e) {
            eventListener.onExeption(TCPConnection.this, e);
            desconnect();
        }

    }
    //синхронизированый Метот закрывает соединение
    public synchronized void desconnect() {
        rxThread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onExeption(TCPConnection.this, e);
        }
    }

    @Override
    public String toString() {
        return "TCPConnection: " + socket.getInetAddress() + ": " + socket.getPort();

    }
}
