package lab3.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Can be created using Builder
 */
@JsonDeserialize(builder = Book.Builder.class)
public class Book implements Comparable<Book> {

    private Integer id;

    private String name;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate dateIn;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate dateOut;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(dateIn, book.dateIn) &&
                Objects.equals(dateOut, book.dateOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateIn, dateOut);
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

    @Override
    public int compareTo(Book book) {
        return getDateIn().compareTo(book.getDateIn());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @JsonPOJOBuilder(withPrefix = "set")
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

        @JsonDeserialize(using = LocalDateDeserializer.class)
        public Builder setDateIn(LocalDate dateIn) {
            book.dateIn = dateIn;
            return this;
        }

        @JsonDeserialize(using = LocalDateDeserializer.class)
        public Builder setDateOut(LocalDate dateOut) {
            book.dateOut = dateOut;
            return this;
        }

        public Book build() {
            return book;
        }

    }

}
