package com.pb.dn131081gmm.hw7;

public class Pants extends Clothes implements WomenClothes, ManClothes {
    Pants (Size size, float prs, String col) {
        super(size, prs, col);
    }

    @Override
    public void dressMan() {
        System.out.println(getClass().getSimpleName() + " размер " + clothesSize.getEuroSize()+ " цена " + price + " цвет " + color);

    }

    @Override
    public void dressWomen() {
        System.out.println(getClass().getSimpleName() + " размер " + clothesSize.getEuroSize()+ " цена " + price + " цвет " + color);

    }
}
