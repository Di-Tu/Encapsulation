package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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

        Product bread1 = new SimpleProduct("Хлеб1", 51);
        Product bread2 = new SimpleProduct("Хлеб2", 52);
        Product bread3 = new SimpleProduct("Хлеб3", 53);
//        Article
        Searchable first = new Article("Первый", "Первый он и есть первый");
        Searchable second = new Article("Второй", "Второй он и есть второй");
        Searchable breadHead = new Article("ХлебГолова", "Хлеб всему голова");
        Searchable breadHead1 = new Article("ХлебГолова1", "Хлеб и Соль всему  голова и еще голова");


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

//        Домашка №3 (Полиморфизм, интерфейсы)
        System.out.println();

        SearchEngine searchEngine = new SearchEngine(17);
        searchEngine.add(orange);
        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(sourCream);
        searchEngine.add(sugar);
        searchEngine.add(mango);
        searchEngine.add(salt);
        searchEngine.add(milk);
        searchEngine.add(saltShaker);
        searchEngine.add(soap);
        searchEngine.add(bread1);
        searchEngine.add(bread2);
        searchEngine.add(bread3);
//        Article
        searchEngine.add(first);
        searchEngine.add(second);
        searchEngine.add(breadHead);
        searchEngine.add(breadHead1);
//        Поиск и вывод
        System.out.println(Arrays.toString(searchEngine.search("Лимон")));
        System.out.println(Arrays.toString(searchEngine.search("Хлеб")));
        System.out.println(Arrays.toString(searchEngine.search("Соль Первый СахарМанго")));
        System.out.println(Arrays.toString(searchEngine.search("Соль")));
        System.out.println(Arrays.toString(searchEngine.search("всему")));
        System.out.println(Arrays.toString(searchEngine.search("Молоко")));

//        Домашка №4
        System.out.println();
        System.out.println("Домашка №4");
        System.out.println("Создаём продукт mango1 с пустым названием:");
        try {
            Product mango1 = new SimpleProduct(null, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Создаём продукт milk1 с ценой 0");
        try {
            Product milk1 = new DiscountedProduct("Молоко", 0, 15);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Создаём продукт milk2 со скидкой 102%");
        try {
            Product milk2 = new DiscountedProduct("Молоко", 115, 102);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
//       Ищем самый подходящий элемент
        System.out.println();
        System.out.println("Ищем самый подходящий элемент");
        try {
            System.out.println(searchEngine.mostSuitableToTheDesired("Голова"));
        } catch (BestResultNotFound e) {
            System.out.println("Строка с вхождением: \"" + e.getMessage() + "\" не найдена");
        }
//        Должно выпасть исключение
        try {
            System.out.println(searchEngine.mostSuitableToTheDesired("Краб"));
        } catch (BestResultNotFound e) {
            System.out.println("Строка с вхождением: \"" + e.getMessage() + "\" не найдена");
        }
    }
}