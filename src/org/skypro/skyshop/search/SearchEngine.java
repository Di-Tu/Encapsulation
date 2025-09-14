package org.skypro.skyshop.search;

import java.util.Arrays;

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


}

