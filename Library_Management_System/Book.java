package Library_Management_System;

public class Book {
    public int bookId;
    public String title;
    public String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}
