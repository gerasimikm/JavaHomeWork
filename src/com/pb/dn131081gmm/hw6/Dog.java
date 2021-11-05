package com.pb.dn131081gmm.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private String nickName;     //кличка
    private String breed;        //порода
    private String ownerAnimal;  // Владелец животного
    private String destiny;        //предназначение
    private int ageAnimal;      //возраст
    private final String NOISE = "лает";

    public Dog(String nickName, String breed, String ownerAnimal, String destiny, int ageAnimal) {
        this.nickName = nickName;
        this.breed = breed;
        this.ownerAnimal = ownerAnimal;
        this.ageAnimal = ageAnimal;
        this.destiny = destiny;
        setFood("мясные консервы и кости");
        setLocation("Вольер");
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака " + getNickName() + " " + NOISE);
    }

    @Override
    public void eat() {
        System.out.println("Собака " + getNickName() + " ест " + getFood());
    }

    @Override
    public String toString() {
        char c;
        if (ageAnimal > 0 && ageAnimal < 5)
            c = 'г';
        else
            c = 'л';
        return ("\nСобака:" +
                "\nКличка............." + nickName +
                "\nПорода............." + breed +
                "\nПредназначение....." + destiny +
                "\nВозраст............" + ageAnimal + c + "." +
                "\nВладелец..........." + ownerAnimal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return (ageAnimal == dog.getAgeAnimal() &&
                Objects.equals(nickName, dog.getNickName()) &&
                Objects.equals(breed, dog.getBreed()) &&
                Objects.equals(ownerAnimal, dog.getOwnerAnimal()) &&
                Objects.equals(ageAnimal, dog.ageAnimal) &&
                Objects.equals(NOISE, dog.getNOISE()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, ageAnimal, breed, ownerAnimal, destiny, NOISE);
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
}
