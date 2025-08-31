package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        Product orange = new SimpleProduct("Апельсин", 130);
        Product apple = new SimpleProduct("Яблоко", 72);
        Product bread = new SimpleProduct("Хлеб", 57);
        Product sourCream = new SimpleProduct("Сметана", 103);
        Product sugar = new SimpleProduct("Сахар", 78);
        Product mango = new SimpleProduct("Манго", 251);
//        Добавляем специальные товары
        Product salt = new DiscountedProduct("Соль", 50, 10);
        Product milk = new DiscountedProduct("Молоко", 90, 15);
        Product saltShaker = new FixPriceProduct("Солонка");
        Product soap = new FixPriceProduct("Мыло");

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

        // Домашка №2
        System.out.println();
        System.out.println("Заполняем корзину Ивана, очищенную ранее. Для проверки добавляем лишний продукт.");
        ivan.addingProductToCart(bread);
        ivan.addingProductToCart(salt);
        ivan.addingProductToCart(milk);
        ivan.addingProductToCart(saltShaker);
        ivan.addingProductToCart(soap);
        ivan.addingProductToCart(sourCream);

        System.out.println();
        System.out.println("Печатаем содержимое корзины Ивана");
        ivan.printBasket();

    }
}