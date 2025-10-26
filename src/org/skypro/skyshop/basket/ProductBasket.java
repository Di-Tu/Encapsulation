package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {

    private Map<String, LinkedList<Product>> basket = new HashMap<>();

    public void addingProductToCart(Product product) {
        this.basket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public int basketValue() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (this.basket == null || this.basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        this.basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("Итого: " + this.basketValue());
        this.getSpecialCount();
    }

    public void getSpecialCount() {
        System.out.println("Специальных товаров: "
                + this.basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count());
    }

    public boolean checkingProductInTheCart(Product product) {
        return basket.containsKey(product.getName());
    }

    public void clearingBasket() {
        basket.clear();
    }

    public List<Product> removingAnItemFromTheBasket(String name) {
        List<Product> deleteProduct = this.basket.values().stream()
                .flatMap(LinkedList::stream)
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());

        this.basket.values().forEach(products ->
                products.removeIf(product -> product.getName().equals(name))
        );

        return deleteProduct;
    }
}

