package lab3.service;

import lab3.model.Book;
import lab3.model.Reader;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderService {

    private Reader reader;

    public ReaderService(Reader reader) {
        this.reader = reader;
    }

    /**
     * Шукає книгу по частині імені книги
     * @partOfName ім'я книги або його частина
     * @return список знайдених книг
     */
    public List<Book> findBooksByPartOfName(String partOfName) {
        return reader.getBooks().stream()
                .filter(b -> b.getName().contains(partOfName))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByDateIn(LocalDate dateIn) {
        return reader.getBooks().stream()
                .filter(b -> b.getDateIn().equals(dateIn))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByName() {
        return reader.getBooks().stream()
                .sorted(Comparator.comparing(Book::getName))
                .collect(Collectors.toList());
    }

}
