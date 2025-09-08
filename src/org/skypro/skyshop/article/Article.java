package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String titleOfArticle;
    private final String textOfArticle;

    public Article(String titleOfArticle, String textOfArticle) {
        this.titleOfArticle = titleOfArticle;
        this.textOfArticle = textOfArticle;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public String objectName() {
        return getStringRepresentation();
    }

    @Override
    public String toString() {
        return "Название статьи: " + titleOfArticle + " Текст статьи: " + textOfArticle;
    }
}
