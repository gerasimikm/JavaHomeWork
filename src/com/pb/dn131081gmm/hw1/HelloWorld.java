package com.pb.dn131081gmm.hw1;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String  str = "1909-09-22".replaceAll("[^\\d]", "").substring(0,8);
        System.out.println("1909-09-02".replaceAll("[^\\d]", "").substring(0,8));
        System.out.println(Integer.parseInt(str.substring(0,4)));
        System.out.println(Integer.parseInt(str.substring(4,6)));
        System.out.println(Integer.parseInt(str.substring(6)));
    }
}
