package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ошибка ввода имени");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Ошибка ввода стоимости");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " :" + price;
    }
}
