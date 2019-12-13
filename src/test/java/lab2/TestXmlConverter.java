package lab2;

import lab2.exception.ConvertException;
import lab2.model.Book;
import lab2.model.Reader;
import lab2.service.XmlConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestXmlConverter {

    private Book book;
    private XmlConverter<Book> bookXmlConverter;

    private Reader reader;
    private XmlConverter<Reader> readerXmlConverter;

    @BeforeTest
    public void beforeTest() {
        bookXmlConverter = new XmlConverter<>(Book.class);
        book = new Book.Builder()
                .setId(1)
                .setName("My Book")
                .setDateIn(LocalDate.of(2019, 2, 4))
                .setDateOut(LocalDate.of(2019, 10, 4))
                .build();

        readerXmlConverter = new XmlConverter<>(Reader.class);
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
        String expected = "<Book><id>1</id><name>My Book</name><dateIn>2019-02-04</dateIn><dateOut>2019-10-04</dateOut></Book>";
        String actual = bookXmlConverter.serializeToString(book);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeBookStringTest() throws ConvertException {
        String xmlString = "<Book><id>1</id><name>My Book</name><dateIn>2019-02-04</dateIn><dateOut>2019-10-04</dateOut></Book>";
        Book actual = bookXmlConverter.deserializeString(xmlString);
        Assert.assertEquals(actual, book);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeBookStringTest() throws ConvertException {
        String xmlString = "<Book><id>1</id><name>My Book</name><dateIn>2019-02-04</dateIn><dateOut>WRONG</dateOut></Book>";
        bookXmlConverter.deserializeString(xmlString);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void serializeReaderStringTest() throws ConvertException {
        String expected = "<Reader><id>1</id><firstName>FirstName</firstName><lastName>LastName</lastName><telephone>+380505050500</telephone><address>Address</address><books><books><id>1</id><name>My Book</name><dateIn>2019-02-04</dateIn><dateOut>2019-10-04</dateOut></books><books><id>2</id><name>My Second Book</name><dateIn>2019-03-05</dateIn><dateOut>2019-11-06</dateOut></books></books></Reader>";
        String actual = readerXmlConverter.serializeToString(reader);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeReaderStringTest() throws ConvertException {
        String xmlString = "<Reader><id>1</id><firstName>FirstName</firstName><lastName>LastName</lastName><telephone>+380505050500</telephone><address>Address</address><books><books><id>1</id><name>My Book</name><dateIn>2019-02-04</dateIn><dateOut>2019-10-04</dateOut></books><books><id>2</id><name>My Second Book</name><dateIn>2019-03-05</dateIn><dateOut>2019-11-06</dateOut></books></books></Reader>";
        Reader actual = readerXmlConverter.deserializeString(xmlString);
        Assert.assertEquals(actual, reader);
    }
}
