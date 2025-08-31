package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private Product[] basket = new Product[5];

    public void addingProductToCart(Product product) {
        for (int i = 0; i <= this.basket.length; i++) {
            if (i == this.basket.length) {
                System.out.println("Невозможно добавить продукт " + product.toString());
                break;
            } else if (this.basket[i] == null) {
                this.basket[i] = product;
                break;
            }
        }
    }

    public int basketValue() {
        int summ = 0;
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] != null) {
                summ = summ + this.basket[i].getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        boolean sign = false;
        int specialProduct = 0;
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] != null) {
                System.out.println(this.basket[i].toString());
                sign = true;
            }
            if (this.basket[i] != null && this.basket[i].isSpecial()) {
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
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] != null && this.basket[i].getName() == product.getName()) {
                sign = true;
                return sign;
            }
        }
        return sign;
    }

    public void clearingBasket() {
        Arrays.fill(this.basket, null);
    }

}

