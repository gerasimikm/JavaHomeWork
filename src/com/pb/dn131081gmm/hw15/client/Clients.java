package com.pb.dn131081gmm.hw15.client;

import com.pb.dn131081gmm.hw15.network.TCPConnection;
import com.pb.dn131081gmm.hw15.network.TCPConnectionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Clients extends JFrame implements ActionListener, TCPConnectionListener {
    public static final String IP_ADDR = "127.0.0.1";
    public static final int PORT = 50055;
    public static final int WIDTH = 600;
    public static final int HIGHT = 300;
    private TCPConnection connection;

    private  final JTextArea text = new JTextArea();
    private  final JTextField fildInput = new JTextField();
    private  final JTextField fildNikName = new JTextField("Misha");

    private Clients(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//предусматривает закрытие она крестиком
        setSize(WIDTH, HIGHT);//задаем размер окна
        setLocationRelativeTo(null);//задаем расположение окна(всегда по центру)
        text.setEditable(false);//запрещаем редактировать поле текста
        text.setLineWrap(true);
        fildInput.addActionListener(this);//слушатель поля ввода, будет отлавливать нажатие Энтера
        add(text, BorderLayout.CENTER);
        add(fildInput, BorderLayout.SOUTH);
        add(fildNikName, BorderLayout.NORTH);

        setVisible(true);

        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   /*     try  {
            Socket socket = new Socket(IP_ADDR, PORT);
            connection = new TCPConnection(Clients.this, socket);
        } catch (IOException e) {
            System.out.println("TCPConnection exeption " + e);;
        }

    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clients();
            }
        });
/*
        Clients client = new  Clients();

        Scanner in = new Scanner(System.in);
        String str = "";
        System.out.print("Ваш ник: ");
        String nikName = in.nextLine();
        while (!(str.toLowerCase()).equals("bay")){

            System.out.print (nikName + ": ");
            str = in.nextLine();
            client.connection.sendMessage(str);
        }

*/

    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Connection ready");
    }

    @Override
    public void onResiveString(TCPConnection tcpConnection, String str) {
        printMsg(str);
    }

    @Override
    public void onDisconect(TCPConnection tcpConnection) {
        //connection.desconnect();
        printMsg("Connection close.");
    }

    @Override
    public void onExeption(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exeption " + e);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fildInput.getText();
        if(msg.equals("")) return; //если поле ввода пустое и нажали энтер то ничего не делается(выход из метода)
        fildInput.setText(null); //очищаем поле ввода
        connection.sendString(fildNikName.getText() + ": " + msg);

    }
    //метод который позволит печать сообщения внутни свинга
    private synchronized void printMsg(String str){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                text.append(str + "\n");
                text.setCaretPosition(text.getDocument().getLength());
        }});
    }
}
