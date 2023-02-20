package Tiket_6_Task_1;

import java.util.Objects;

public class Book {
    private final String bookTitle;

    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookTitle().equals(book.getBookTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookTitle());
    }

    @Override
    public String toString() {
        return  bookTitle;
    }
}
