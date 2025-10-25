package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String titleOfArticle;
    private final String textOfArticle;

    public Article(String titleOfArticle, String textOfArticle) {
        this.titleOfArticle = titleOfArticle;
        this.textOfArticle = textOfArticle;
    }

    @Override
    public String searchTerm() {
        return titleOfArticle;
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
        return "Название статьи: " + titleOfArticle + " - Текст статьи: " + textOfArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        return Objects.equals(this.titleOfArticle, ((Article) o).titleOfArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleOfArticle);
    }
}
