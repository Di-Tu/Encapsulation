package org.skypro.skyshop.product;

public abstract class Product {
    private String name;


    public Product(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ошибка ввода имени");
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name;
    }
}
