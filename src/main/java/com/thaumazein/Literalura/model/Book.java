package com.thaumazein.Literalura.model;

import jakarta.persistence.*;

public class Book {
    private Long id;
    private String title;
    private Author author;
    private String language;
    private int downloadCount;

    public Book() {
    }

    public Book(String title, Author author, String language, int downloadCount) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.downloadCount = downloadCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return """
                Titulo: %s
                Autor: %s
                Idioma: %s
                Quantidade de Downloads: %d""".formatted(title, author, language, downloadCount);
    }
}
