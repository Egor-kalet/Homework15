package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {

    private final int basePrice;
    private final int discount;
    private final UUID id;


    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.id = UUID.randomUUID();
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getPrice() {
        double finalPrice = basePrice - (basePrice * (discount/100d));
        return (int) finalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return  getName() + ": " + getPrice() + " (" + getDiscount() + ")";
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
