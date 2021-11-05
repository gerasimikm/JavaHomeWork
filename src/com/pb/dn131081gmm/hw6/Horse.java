package com.pb.dn131081gmm.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private String nickName;     //кличка
    private String breed;        //порода
    private String ownerAnimal;  // Владелец животного
    private int ageAnimal;      //возраст
    private int weight;         //вес
    private final String NOISE = "ржет";

    public Horse(String nickName, String breed, String ownerAnimal, int ageAnimal, int weight) {
        this.nickName = nickName;
        this.breed = breed;
        this.ownerAnimal = ownerAnimal;
        this.ageAnimal = ageAnimal;
        this.weight = weight;
        setFood("овес, сено, траву");
        setLocation("Стойло");
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь " + getNickName() + " " + NOISE);
    }

    @Override
    public void eat() {
        System.out.println("Лошадь " + getNickName() + " ест: " + getFood());
    }

    @Override
    public String toString() {
        char c;
        if (ageAnimal > 0 && ageAnimal < 5)
            c = 'г';
        else
            c = 'л';
        return ("\nЛошадь:" +
                "\nКличка....." + nickName +
                "\nПорода....." + breed +
                "\nВес........" + weight + "кг." +
                "\nВозраст...." + ageAnimal + c + "." +
                "\nВладелец..." + ownerAnimal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return (ageAnimal == horse.getAgeAnimal() && weight == horse.getWeight() &&
                Objects.equals(nickName, horse.getNickName()) &&
                Objects.equals(breed, horse.getBreed()) &&
                Objects.equals(ownerAnimal, horse.getOwnerAnimal()) &&
                Objects.equals(NOISE, horse.getNOISE()));
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOwnerAnimal() {
        return ownerAnimal;
    }

    public void setOwnerAnimal(String ownerAnimal) {
        this.ownerAnimal = ownerAnimal;
    }

    public int getAgeAnimal() {
        return ageAnimal;
    }

    public void setAgeAnimal(int ageAnimal) {
        this.ageAnimal = ageAnimal;
    }

    public String getNOISE() {
        return NOISE;
    }

    public int getWeight() {
        return weight;
    }
}
