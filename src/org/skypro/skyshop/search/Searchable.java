package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String contentType();

    String objectName();

    default String getStringRepresentation() {
        return '\"' + "имя " + searchTerm() + " -объекта - тип " + contentType() + " -объекта" + '\"';
    }
}
