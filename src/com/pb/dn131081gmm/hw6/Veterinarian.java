package com.pb.dn131081gmm.hw6;

public class Veterinarian {
    public void treatAnimal(Animal animal) {
        if (animal instanceof Cat) {
            System.out.println("\nНа приеме у врача кот " + ((Cat) animal).getNickName() +
                    ".\nПосадить в " + ((Cat) animal).getLocation() + ".\nЕст " + ((Cat) animal).getFood());
        } else if (animal instanceof Dog) {
            System.out.println("\nНа приеме собака " + ((Dog) animal).getNickName() +
                    ".\nПосадить в " + ((Dog) animal).getLocation() + ".\nЕст " + ((Dog) animal).getFood());
        } else if (animal instanceof Horse) {
            System.out.println("\nНа приеме собака " + ((Horse) animal).getNickName() +
                    ".\nПосадить в " + ((Horse) animal).getLocation() + ".\nЕст " + ((Horse) animal).getFood());
        }
    }
}
