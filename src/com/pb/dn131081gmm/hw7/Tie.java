package com.pb.dn131081gmm.hw7;

public class Tie extends Clothes implements ManClothes{

    Tie(Size size, float prs, String col) {
        super(size, prs, col);
    }

    @Override
    public void dressMan() {
        System.out.println(getClass().getSimpleName() + " размер " + clothesSize.getEuroSize()+ " цена " + price + " цвет " + color);

    }
}
