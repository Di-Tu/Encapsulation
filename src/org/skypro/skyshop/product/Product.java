package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;


    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ошибка ввода имени");
        }
        this.name = name;
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String contentType() {
        return "PRODUCT";
    }

    @Override
    public String objectName() {
        return getStringRepresentation();
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
