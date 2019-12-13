package lab2;

import lab2.exception.ConvertException;
import lab2.model.Book;
import lab2.model.Reader;
import lab2.service.JsonConverter;
import lab2.service.XmlConverter;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws ConvertException {
        Reader reader = new Reader.Builder()
                .setId(1)
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setAddress("Address")
                .setTelephone("+380505050500")
                .build();

        reader.addBook(new Book.Builder()
                .setId(1)
                .setName("My Book")
                .setDateIn(LocalDate.of(2019, 2, 4))
                .setDateOut(LocalDate.of(2019, 10, 4))
                .build());
        reader.addBook(new Book.Builder()
                .setId(2)
                .setName("My Second Book")
                .setDateIn(LocalDate.of(2019, 3, 5))
                .setDateOut(LocalDate.of(2019, 11, 6))
                .build());

        JsonConverter<Reader> readerJsonConverter = new JsonConverter<>(Reader.class);
        readerJsonConverter.serializeToFile(reader, "reader_result.json");

        XmlConverter<Reader> readerXmlConverter = new XmlConverter<>(Reader.class);
        readerXmlConverter.serializeToFile(reader, "reader_result.xml");
    }

}
