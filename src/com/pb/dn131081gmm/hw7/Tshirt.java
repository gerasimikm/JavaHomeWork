package com.pb.dn131081gmm.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{
       Tshirt (Size size, float prs, String col) {
        super(size, prs, col);
    }

    @Override
    public void dressMan() {
        System.out.println(getClass().getSimpleName() + " размер " + clothesSize.getEuroSize()+ " цена " + price + " цвет " + color);
    }

    @Override
    public void dressWomen() {
        System.out.println(getClass().getSimpleName() + " размер " + clothesSize.getEuroSize() + " цена " + price + " цвет " + color);

    }
}
