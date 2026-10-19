package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE_PRODUCT = 50;
    private final UUID id;


    public FixPriceProduct(String name) {
        super(name);
        this.id = UUID.randomUUID();
    }

    public  int getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return  getName() + ": Фиксированная цена " + getPrice();
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
