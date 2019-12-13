package lab1.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Can be created using Builder
 */
public class Book {

    private Integer id;

    private String name;

    private LocalDate dateIn;

    private LocalDate dateOut;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(id, book.id)) return false;
        if (!Objects.equals(name, book.name)) return false;
        if (!Objects.equals(dateIn, book.dateIn)) return false;
        return Objects.equals(dateOut, book.dateOut);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateIn != null ? dateIn.hashCode() : 0);
        result = 31 * result + (dateOut != null ? dateOut.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public static class Builder {

        Book book;

        public Builder() {
            book = new Book();
        }

        public Builder setId(Integer id) {
            book.id = id;
            return this;
        }

        public Builder setName(String name) {
            book.name = name;
            return this;
        }

        public Builder setDateIn(LocalDate dateIn) {
            book.dateIn = dateIn;
            return this;
        }

        public Builder setDateOut(LocalDate dateOut) {
            book.dateOut = dateOut;
            return this;
        }

        public Book build() {
            return book;
        }

    }

}
