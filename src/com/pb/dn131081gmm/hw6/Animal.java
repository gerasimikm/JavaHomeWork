package com.pb.dn131081gmm.hw6;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Animal {
    private String food;
    private String location;

    public void makeNoise() {
        System.out.println("Животное Шумит");
    }

    public void eat() {
        System.out.println("Животное ест");
    }

    public void sleep() {
        System.out.println("Животное спит");
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}