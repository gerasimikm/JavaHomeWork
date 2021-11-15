package com.pb.dn131081gmm.hw7;

import com.pb.dn131081gmm.hw6.Cat;

import java.util.SortedMap;

public class Atelier {
    public static void dressMan(Clothes[] clothes){
        for (Clothes i: clothes){
            if (i instanceof ManClothes) {
                ((ManClothes) i).dressMan();
            }

        }
    }
    public static void  dressWomen(Clothes[] clothes){
        for (Clothes i: clothes){
            if (i instanceof WomenClothes) {
                ((WomenClothes) i).dressWomen();
            }

        }

    }
    public static void main(String[] args) {
        Clothes[] allClothes = new Clothes[]{new Tshirt(Size.M,250,"Красный"),
                                             new Pants(Size.L,200,"Черный"),
                                             new Skirt(Size.S,150,"Синий"),
                                             new Tie(Size.SL,250,"Серебристый")};
        System.out.println("\nРезузьтат вызова метода dressWomen(Clothes[] clothes):");
        dressWomen(allClothes);
        System.out.println("\nРезузьтат вызова метода dressMan(Clothes[] clothes):");
        dressMan(allClothes);
    }
}
