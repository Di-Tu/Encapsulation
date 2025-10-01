package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private Map<String, LinkedList<Product>> basket = new HashMap<>();

    public void addingProductToCart(Product product) {
        this.basket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public int basketValue() {
        int summ = 0;
        for (Map.Entry<String, LinkedList<Product>> entry : this.basket.entrySet()) {
            LinkedList<Product> products = entry.getValue();
            for (Product product : products) {
                if (product != null) {
                    summ += product.getPrice();
                }
            }
        }
        return summ;
    }

    public void printBasket() {
        boolean sign = false;
        int specialProduct = 0;
        for (Map.Entry<String, LinkedList<Product>> entry : this.basket.entrySet()) {
            LinkedList<Product> products = entry.getValue();
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product.toString());
                    sign = true;
                }
                if (product != null && product.isSpecial()) {
                    specialProduct++;
                }
            }
        }
        if (!sign) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + this.basketValue());
            System.out.println("Специальных товаров: " + specialProduct);
        }
    }

    public boolean checkingProductInTheCart(Product product) {
        boolean sign = false;
        for (Map.Entry<String, LinkedList<Product>> entry : this.basket.entrySet()) {
            LinkedList<Product> products = entry.getValue();
            for (Product prod : products) {
                if (prod != null && prod.getName() == product.getName()) {
                    sign = true;
                    return sign;
                }
            }
        }
        return sign;
    }

    public void clearingBasket() {
        basket.clear();
    }

    public List<Product> removingAnItemFromTheBasket(String name) {
        List<Product> deleteProduct = new LinkedList<>();
        for (Map.Entry<String, LinkedList<Product>> entry : this.basket.entrySet()) {
            LinkedList<Product> products = entry.getValue();
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    deleteProduct.add(product);
                    iterator.remove();
                }
            }
        }
        return deleteProduct;
    }
}

