package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        Product orange = new Product("Апельсин", 130);
        Product apple = new Product("Яблоко", 72);
        Product bread = new Product("Хлеб", 57);
        Product sourCream = new Product("Сметана", 103);
        Product sugar = new Product("Сахар", 78);
        Product mango = new Product("Манго", 251);

        ProductBasket ivan = new ProductBasket();
        ProductBasket irina = new ProductBasket();
        ProductBasket artem = new ProductBasket();

        System.out.println();
        System.out.println("Заполняем корзину Ивана");
        ivan.addingProductToCart(apple);
        ivan.addingProductToCart(sourCream);
        ivan.addingProductToCart(sugar);

        System.out.println();
        System.out.println("Заполняем корзину Ирины");
        irina.addingProductToCart(bread);
        irina.addingProductToCart(orange);
        irina.addingProductToCart(mango);
        irina.addingProductToCart(apple);
        irina.addingProductToCart(sugar);
        irina.addingProductToCart(sourCream);

        System.out.println();
        System.out.println("Корзина Ивана: ");
        ivan.printBasket();

        System.out.println();
        System.out.println("Корзина Ирины: ");
        irina.printBasket();

        System.out.println();
        System.out.println("Корзина Артёма: ");
        artem.printBasket();

        System.out.println();
        System.out.println("Стоимость корзины Ивана: " + ivan.basketValue());

        System.out.println();
        System.out.println("Стоимость корзины Ирины: " + irina.basketValue());

        System.out.println();
        System.out.println("Стоимость корзины Артема: " + artem.basketValue());

        System.out.println();
        System.out.println("Проверяем наличие сметаны в корзине Ивана: ");
        if (ivan.checkingProductInTheCart(sourCream)) {
            System.out.println("Продукт сметана, присутствует в корзине Ивана");
        } else {
            System.out.println("Продукта сметана, нет в корзине Ивана");
        }

        System.out.println();
        System.out.println("Проверяем наличие сметаны в корзине Ирины: ");
        if (irina.checkingProductInTheCart(sourCream)) {
            System.out.println("Продукт сметана, присутствует в корзине Ирины");
        } else {
            System.out.println("Продукта сметана, нет в корзине Ирины");
        }

        System.out.println();
        System.out.println("Очищаем корзину Ивана");
        ivan.clearingBasket();

        System.out.println();
        System.out.println("Печатаем корзину Ивана:");
        ivan.printBasket();

        System.out.println();
        System.out.println("Стоимость корзины Ивана: " + ivan.basketValue());

        System.out.println();
        System.out.println("Проверяем наличие сметаны в корзине Ивана: ");
        if (ivan.checkingProductInTheCart(sourCream)) {
            System.out.println("Продукт сметана, присутствует в корзине Ивана");
        } else {
            System.out.println("Продукта сметана, нет в корзине Ивана");
        }

    }
}