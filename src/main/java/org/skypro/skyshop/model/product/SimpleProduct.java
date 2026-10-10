package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct  extends Product {
    private final int price;
    private final UUID id;


    public SimpleProduct( String name, int price) {
        super(name);
        this.id = UUID.randomUUID();
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  getName() + ": " + getPrice();
    }


    @Override
    public boolean isSpecial(){
        return false;
    }
}
