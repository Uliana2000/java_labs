package lab1.model;

import java.util.Objects;

public class Subscription {

    private Reader reader;

    private Book book;

    public Subscription(Reader reader, Book book) {
        this.reader = reader;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (!Objects.equals(reader, that.reader)) return false;
        return Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        int result = reader != null ? reader.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "reader=" + reader +
                ", book=" + book +
                '}';
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }
}
