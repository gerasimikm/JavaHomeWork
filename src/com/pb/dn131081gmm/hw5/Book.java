package com.pb.dn131081gmm.hw5;

public class Book {
    private String titleBook;
    private String author;
    private int yearPublication;

    public Book(String titleBook, String author, int yearPublication) {
        this.titleBook = titleBook;
        this.author = author;
        this.yearPublication = yearPublication;
    }

    @Override
    public String toString() {
        return '\'' + titleBook + "\', " + author + ", " + yearPublication + "г.";
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public String getAuthor() {
        return author;
    }

}
