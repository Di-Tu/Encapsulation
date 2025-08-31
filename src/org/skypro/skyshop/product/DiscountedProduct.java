package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int price;
    private int discountInWholePercentages;

    public DiscountedProduct(String name, int price, int discountInWholePercentages) {
        super(name);
        this.price = price;
        this.discountInWholePercentages = discountInWholePercentages;
    }

    @Override
    public int getPrice() {
        return (this.price - discountInWholePercentages);
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getPrice() + " ( " + this.discountInWholePercentages + "% )";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
