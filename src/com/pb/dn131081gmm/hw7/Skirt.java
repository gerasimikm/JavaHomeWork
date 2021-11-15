package com.pb.dn131081gmm.hw7;

public class Skirt extends Clothes implements  WomenClothes{

    Skirt(Size size, float prs, String col) {
        super(size, prs, col);
    }

    @Override
    public void dressWomen() {
        System.out.println(getClass().getSimpleName() + " размер " + clothesSize.getEuroSize()+ " цена " + price + " цвет " + color);

    }
}
