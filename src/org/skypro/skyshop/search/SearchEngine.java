package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

    private List<Searchable> searchable = new LinkedList<>();

    public List<Searchable> search(String query) {
        LinkedList<Searchable> result = new LinkedList<>();
        for (Searchable element : this.searchable) {
            if (element.objectName().contains(query)) {
                result.add(element);
            }
        }
        return result;
    }

    public void add(Searchable object) {
        for (Searchable element : this.searchable) {
            if (element == null) {
                element = object;
                break;
            }
        }
        this.searchable.add(object);
    }

    public Searchable mostSuitableToTheDesired(String query) throws BestResultNotFound {
        List<Searchable> arrayOfMatches = search(query);
        Searchable result = null;
        int flag = 0;
        for (Searchable element : arrayOfMatches) {
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
        if (result == null) {
            throw new BestResultNotFound(query);
        }
        return result;
    }
}

