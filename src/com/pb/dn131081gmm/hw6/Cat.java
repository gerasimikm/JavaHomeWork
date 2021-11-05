package com.pb.dn131081gmm.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private String nickName;     //кличка
    private String breed;        //порода
    private String ownerAnimal;  // Владелец животного
    private int ageAnimal;      //возраст
    private String sex;          //пол
    private final String NOISE = "мяукает";

    public Cat(String nickName, String breed, String ownerAnimal, String sex, int ageAnimal) {
        this.nickName = nickName;
        this.breed = breed;
        this.ownerAnimal = ownerAnimal;
        this.ageAnimal = ageAnimal;
        this.sex = sex;
        setFood("рыбу и молоко");
        setLocation("Клетка");
    }

    @Override
    public void makeNoise() {
        System.out.println("Кот " + getNickName() + " " + NOISE);
    }

    @Override
    public void eat() {
        System.out.println("Кот " + getNickName() + " ест " + getFood());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, ageAnimal, breed, ownerAnimal, sex, NOISE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return (ageAnimal == cat.getAgeAnimal() &&
                Objects.equals(nickName, cat.getNickName()) &&
                Objects.equals(breed, cat.getBreed()) &&
                Objects.equals(ownerAnimal, cat.getOwnerAnimal()) &&
                Objects.equals(ageAnimal, cat.ageAnimal) &&
                Objects.equals(sex, cat.sex) &&
                Objects.equals(NOISE, cat.getNOISE()));
    }

    @Override
    public String toString() {
        char c;
        if (ageAnimal > 0 && ageAnimal < 5)
            c = 'г';
        else
            c = 'л';
        return ("\nКошка:" +
                "\nКличка....." + nickName +
                "\nПорода....." + breed +
                "\nПол........" + sex +
                "\nВозраст...." + ageAnimal + c + "." +
                "\nВладелец..." + ownerAnimal);
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

    public String getSex() {
        return sex;
    }

}

