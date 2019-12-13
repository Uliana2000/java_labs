package lab3;

import lab3.model.Book;
import lab3.model.Reader;
import lab3.service.ReaderService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestReaderService {

    private Book first;
    private Book second;
    private ReaderService readerService;

    @BeforeTest
    public void beforeTest() {
        Reader reader = new Reader.Builder()
                .setId(1)
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setAddress("Address")
                .setTelephone("+380505050500")
                .build();

        first = new Book.Builder()
                .setId(1)
                .setName("B My Book")
                .setDateIn(LocalDate.of(2019, 2, 4))
                .setDateOut(LocalDate.of(2019, 10, 4))
                .build();

        reader.addBook(first);

        second = new Book.Builder()
                .setId(2)
                .setName("A My Second Book")
                .setDateIn(LocalDate.of(2019, 3, 5))
                .setDateOut(LocalDate.of(2019, 11, 6))
                .build();

        reader.addBook(second);

        readerService = new ReaderService(reader);
    }

    @Test
    public void testFindBooksByPartOfName() {
        Object[] expected = { second };
        Object[] actual = readerService.findBooksByPartOfName("Second").toArray();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindBooksByDateIn() {
        Object[] expected = { first };
        Object[] actual = readerService.findBooksByDateIn(LocalDate.of(2019, 2, 4)).toArray();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByName() {
        Object[] expected = { second, first };
        Object[] actual = readerService.sortBooksByName().toArray();
        Assert.assertEquals(actual, expected);
    }

}
