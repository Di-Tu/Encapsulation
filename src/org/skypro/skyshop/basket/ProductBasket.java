package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private List<Product> basket = new LinkedList<>();

    public void addingProductToCart(Product product) {
        this.basket.add(product);
    }

    public int basketValue() {
        int summ = 0;
        for (Product element : this.basket) {
            if (element != null) {
                summ = summ + element.getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        boolean sign = false;
        int specialProduct = 0;
        for (Product element : this.basket) {
            if (element != null) {
                System.out.println(element.toString());
                sign = true;
            }
            if (element != null && element.isSpecial()) {
                specialProduct++;
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
        for (Product element : this.basket) {
            if (element != null && element.getName() == product.getName()) {
                sign = true;
                return sign;
            }
        }
        return sign;
    }

    public void clearingBasket() {
        basket.clear();
    }

    public List removingAnItemFromTheBasket(String name) {
        Iterator<Product> iterator = basket.iterator();
        List<Product> deleteProduct = new LinkedList<>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                deleteProduct.add(product);
                iterator.remove();
            }
        }
        return deleteProduct;
    }
}

