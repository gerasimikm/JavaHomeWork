package com.pb.dn131081gmm.hw6;

public class VetClinic {
    public static void main(String[] args) throws Exception {
            Animal[] allAnimas = new Animal[4];
            Cat mayCat = new Cat("Мурчик", "Сфинкс", "Сидоренко М.И.", "male", 2);
            Cat mayCat1 = new Cat("Мурка", "Сфинкс", "Сидоренко М.И.", "female", 2);
            Dog mayDog = new Dog("Барсик", "Дворняга", "Руденко О.М.", "Сторожевая", 5);
            Horse mayHorse = new Horse("Буран", "Фризская", "Осипов А.И.", 7, 800);
            allAnimas[0] = mayCat;
            allAnimas[1] = mayCat1;
            allAnimas[2] = mayDog;
            allAnimas[3] = mayHorse;

            System.out.println("Перечень всех животных:");
            for (int i = 0; i < allAnimas.length; i++) {
                if (allAnimas[i] instanceof Cat) {
                    System.out.println(((Cat) allAnimas[i]).toString());
                }
                if (allAnimas[i] instanceof Dog) {
                    System.out.println(((Dog) allAnimas[i]).toString());
                }
                if (allAnimas[i] instanceof Horse) {
                    System.out.println(((Horse) allAnimas[i]).toString());
                }
            }

            System.out.println("ВЫЗОВ МЕТОДОВ makeNoise, eat \nДЛЯ КОТА:");
            mayCat.makeNoise();
            mayCat.eat();
            System.out.println("\nДЛЯ СОБАКИ:");
            mayDog.makeNoise();
            mayDog.eat();
            System.out.println("\nДЛЯ ЛОШАДИ:");
            mayHorse.makeNoise();
            mayHorse.eat();

            System.out.println("\nСРАВНЕНИЕ ОБЬЕКТОВ mayCat И mayCat1");
            if (mayCat.equals(mayCat1))
                System.out.println("Это один и тот же кот");
            else
                System.out.println("Это разные котики");

            System.out.print("\nПОСЕЩЕНИЕ ВРАЧА");
            Class clazz = Class.forName("com.pb.dn131081gmm.hw6.Veterinarian");
            Object obg = clazz.newInstance();
            if (obg instanceof Veterinarian) {
                ((Veterinarian) obg).treatAnimal(allAnimas[0]);
            }

        }
}
