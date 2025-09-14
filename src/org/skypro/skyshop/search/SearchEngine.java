package org.skypro.skyshop.search;

import java.util.Arrays;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {

    private Searchable[] searchable;

    public SearchEngine(int size) {
        this.searchable = new Searchable[size];
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int counter = 0;
        for (Searchable element : this.searchable) {
            if (element.objectName().contains(query)) {
                result[counter] = element;
                counter++;
            }
            if (counter == 5) {
                break;
            }
        }
        return result;
    }

    public void add(Searchable object) {
        for (int i = 0; i < this.searchable.length; i++) {
            if (this.searchable[i] == null) {
                this.searchable[i] = object;
                break;
            }
        }
    }

    public Searchable mostSuitableToTheDesired(String query) throws BestResultNotFound {
        Searchable[] arrayOfMatches = search(query);
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

