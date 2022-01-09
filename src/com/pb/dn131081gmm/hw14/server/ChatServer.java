package com.pb.dn131081gmm.hw14.server;

import com.pb.dn131081gmm.hw14.network.TCPConnection;
import com.pb.dn131081gmm.hw14.network.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener {
    private ArrayList<TCPConnection> allConnections = new ArrayList<>();

    private ChatServer() {
        System.out.println("Server runing...");
        try (ServerSocket serverSocket = new ServerSocket(50055)) {
            while (true) {
                try {
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.out.println("TCPConnection exeption " + e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();

    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        allConnections.add(tcpConnection);
        sendToAllMessage("Client connected  " + tcpConnection);
    }

    @Override
    public synchronized void onResiveString(TCPConnection tcpConnection, String str) {
        sendToAllMessage(str);

    }

    @Override
    public synchronized void onDisconect(TCPConnection tcpConnection) {
        allConnections.remove(tcpConnection);

    }

    @Override
    public synchronized void onExeption(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exeption " + e);
    }

    //отослать строку всем участникам чата
    private void sendToAllMessage(String str) {
        System.out.println(str);
        final int cnt = allConnections.size();
        for (int i = 0; i < cnt; i++)
            allConnections.get(i).sendString(str);

    }
}

