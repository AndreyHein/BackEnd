package de.ait_tr.dz20240808.entity;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String publisherDate;
    private int pages;
    private String genre;

    public Book(Long id, String title, String author, String publisherDate, int pages, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisherDate = publisherDate;
        this.pages = pages;
        this.genre = genre;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisherDate() {
        return publisherDate;
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }
}