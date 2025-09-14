package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        try {
            if (price <= 0) {
                throw new IllegalArgumentException();
            }
            this.price = price;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода стоимости");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
