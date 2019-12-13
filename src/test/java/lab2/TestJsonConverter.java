package lab2;

import lab2.exception.ConvertException;
import lab2.model.Book;
import lab2.model.Reader;
import lab2.service.JsonConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestJsonConverter {

    private Book book;
    private JsonConverter<Book> bookJsonConverter;

    private Reader reader;
    private JsonConverter<Reader> readerJsonConverter;

    @BeforeTest
    public void beforeTest() {
        bookJsonConverter = new JsonConverter<>(Book.class);
        book = new Book.Builder()
                .setId(1)
                .setName("My Book")
                .setDateIn(LocalDate.of(2019, 2, 4))
                .setDateOut(LocalDate.of(2019, 10, 4))
                .build();

        readerJsonConverter = new JsonConverter<>(Reader.class);
        reader = new Reader.Builder()
                .setId(1)
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setAddress("Address")
                .setTelephone("+380505050500")
                .build();

        reader.addBook(book);
        reader.addBook(new Book.Builder()
                .setId(2)
                .setName("My Second Book")
                .setDateIn(LocalDate.of(2019, 3, 5))
                .setDateOut(LocalDate.of(2019, 11, 6))
                .build());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void serializeBookStringTest() throws ConvertException {
        String expected = "{\"id\":1,\"name\":\"My Book\",\"dateIn\":\"2019-02-04\",\"dateOut\":\"2019-10-04\"}";
        String actual = bookJsonConverter.serializeToString(book);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeBookStringTest() throws ConvertException {
        String jsonString = "{\"id\":1,\"name\":\"My Book\",\"dateIn\":\"2019-02-04\",\"dateOut\":\"2019-10-04\"}";
        Book actual = bookJsonConverter.deserializeString(jsonString);
        Assert.assertEquals(actual, book);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeBookStringTest() throws ConvertException {
        String jsonString = "{\"id\":1,\"name\":\"My Book\",\"dateIn\":\"2019-02-04\",\"dateOut\":\"WRONG\"}";
        bookJsonConverter.deserializeString(jsonString);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void serializeReaderStringTest() throws ConvertException {
        String expected = "{\"id\":1,\"firstName\":\"FirstName\",\"lastName\":\"LastName\",\"telephone\":\"+380505050500\",\"address\":\"Address\",\"books\":[{\"id\":1,\"name\":\"My Book\",\"dateIn\":\"2019-02-04\",\"dateOut\":\"2019-10-04\"},{\"id\":2,\"name\":\"My Second Book\",\"dateIn\":\"2019-03-05\",\"dateOut\":\"2019-11-06\"}]}";
        String actual = readerJsonConverter.serializeToString(reader);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeReaderStringTest() throws ConvertException {
        String jsonString = "{\"id\":1,\"firstName\":\"FirstName\",\"lastName\":\"LastName\",\"telephone\":\"+380505050500\",\"address\":\"Address\",\"books\":[{\"id\":1,\"name\":\"My Book\",\"dateIn\":\"2019-02-04\",\"dateOut\":\"2019-10-04\"},{\"id\":2,\"name\":\"My Second Book\",\"dateIn\":\"2019-03-05\",\"dateOut\":\"2019-11-06\"}]}";
        Reader actual = readerJsonConverter.deserializeString(jsonString);
        Assert.assertEquals(actual, reader);
    }
}
