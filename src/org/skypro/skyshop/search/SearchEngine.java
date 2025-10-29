package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {

    private Map<String, HashSet<Searchable>> searchable = new TreeMap<>();

    public Set<Searchable> search(String query) {
        return searchable.values().stream()
                .flatMap(HashSet::stream)
                .filter(element -> element.searchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>((o1, o2) -> {
                    int length1 = o1.searchTerm().length();
                    int length2 = o2.searchTerm().length();
                    if (length1 == length2) {
                        return o2.searchTerm().compareTo(o1.searchTerm());
                    }
                    return length2 - length1;
                })));
    }

    public void add(Searchable object) {
        this.searchable.computeIfAbsent(object.objectName(), k -> new HashSet<Searchable>()).add(object);
    }

    public Searchable mostSuitableToTheDesired(String query) throws BestResultNotFound {
        Searchable result = null;
        int flag = 0;
        for (Map.Entry<String, HashSet<Searchable>> entry : this.searchable.entrySet()) {
            HashSet<Searchable> value = entry.getValue();
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

    public void printMap(Set mapPrint) {
        if (mapPrint.isEmpty()) {
            System.out.println("Отсутствует");
            System.out.println();
            return;
        }
        for (Object value : mapPrint) {
            System.out.println(value);
        }
        System.out.println();
    }
}

