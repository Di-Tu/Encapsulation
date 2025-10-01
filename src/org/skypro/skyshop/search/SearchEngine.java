package org.skypro.skyshop.search;

import java.util.*;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

    private Map<String, LinkedList<Searchable>> searchable = new TreeMap<>();


    public Map<String, LinkedList<Searchable>> search(String query) {
        Map<String, LinkedList<Searchable>> result = new TreeMap<>();
        for (Map.Entry<String, LinkedList<Searchable>> entry : this.searchable.entrySet()) {
            String key = entry.getKey();
            LinkedList<Searchable> value = entry.getValue();
            for (Searchable element : value) {
                if (element.objectName().contains(query)) {
                    result.computeIfAbsent(key, k -> new LinkedList<>()).add(element);
                }
            }
        }
        return result;
    }

    public void add(Searchable object) {
        this.searchable.computeIfAbsent(object.objectName(), k -> new LinkedList<>()).add(object);
    }

    public Searchable mostSuitableToTheDesired(String query) throws BestResultNotFound {
        Map<String, LinkedList<Searchable>> arrayOfMatches = search(query);
        Searchable result = null;
        int flag = 0;
        for (Map.Entry<String, LinkedList<Searchable>> entry : this.searchable.entrySet()) {
            LinkedList<Searchable> value = entry.getValue();
            for (Searchable element : value) {
                int quantity = 0;
                int index = 0;
                if (element == null) {
                    continue;
                }
                int substringIndex = element.objectName().indexOf(query, index);
                while (substringIndex != -1) {
                    quantity++;
                    index = substringIndex + query.length();
                    substringIndex = element.objectName().indexOf(query, index);
                }
                if (quantity > flag) {
                    result = element;
                }
            }
        }
        if (result == null) {
            throw new BestResultNotFound(query);
        }
        return result;
    }

    public void printMap(Map mapPrint) {
        Map<String, LinkedList<Searchable>> print = mapPrint;
        if (mapPrint.isEmpty()) {
            System.out.println("Отсутствует");
            System.out.println();
            return;
        }
        for (Map.Entry<String, LinkedList<Searchable>> entry : print.entrySet()) {
            String key = entry.getKey();
            LinkedList<Searchable> value = entry.getValue();
            for (Searchable element : value) {
                System.out.println(key + element);
            }
        }
        System.out.println();
    }
}

