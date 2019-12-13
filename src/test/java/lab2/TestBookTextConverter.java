package lab2;

import lab2.exception.ConvertException;
import lab2.model.Book;
import lab2.service.BookTextConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestBookTextConverter {

    private BookTextConverter bookTextConverter;
    private Book book;

    @BeforeTest
    public void beforeTest() {
        bookTextConverter = new BookTextConverter();
        book = new Book.Builder()
                .setId(1)
                .setName("My Book")
                .setDateIn(LocalDate.of(2019, 2, 4))
                .setDateOut(LocalDate.of(2019, 10, 4))
                .build();
    }

    @Test
    public void serializeToStringTest() throws ConvertException {
        String expected = "1##My Book##2019-02-04##2019-10-04";
        String actual = bookTextConverter.serializeToString(book);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeStringTest() throws ConvertException {
        String serialized = "1##My Book##2019-02-04##2019-10-04";
        Book actual = bookTextConverter.deserializeString(serialized);
        Assert.assertEquals(actual, book);
    }

    @DataProvider
    public Object[][] negativeDeserializeStringDataProvider() {
        return new Object[][]{
                {"1##My Book##2019-02-04##WRONG"},
                {"1##My Book##2019-02-04##"},
                {"TEXT##My Book##2019-02-04##2019-10-04"},
                {"1##My Book#2019-02-04##2019-10-04"},
                {"My Book##2019-02-04##2019-10-04"}
        };
    }

    @Test(expectedExceptions = ConvertException.class, dataProvider = "negativeDeserializeStringDataProvider")
    public void negativeDeserializeStringTest(String serializedString) throws ConvertException {
        bookTextConverter.deserializeString(serializedString);
    }

}
