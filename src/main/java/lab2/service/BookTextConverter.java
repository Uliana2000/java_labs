package lab2.service;

import lab2.exception.ConvertException;
import lab2.model.Book;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookTextConverter implements Converter<Book> {

    private final String FIELDS_SEPARATOR = "##";
    private final Integer FIELDS_COUNT = 4;

    private Object[] getBookFields(Book book) {
        return new Object[]{
            book.getId(), book.getName(), book.getDateIn(), book.getDateOut()
        };
    }

    @Override
    public String serializeToString(Book book) throws ConvertException {
        try {
            Object[] bookFields = getBookFields(book);

            List<String> stringFields = Arrays.stream(bookFields)
                    .map(Object::toString)
                    .collect(Collectors.toList());

            return String.join(FIELDS_SEPARATOR, stringFields);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    @Override
    public Book deserializeString(String serializedString) throws ConvertException {
        try {
            String[] stringFields = serializedString.split(FIELDS_SEPARATOR);

            if (stringFields.length != FIELDS_COUNT) {
                throw new Exception("Invalid format of string!");
            }

            return new Book.Builder()
                    .setId(Integer.parseInt(stringFields[0]))
                    .setName(stringFields[1])
                    .setDateIn(LocalDate.parse(stringFields[2]))
                    .setDateOut(LocalDate.parse(stringFields[3]))
                    .build();
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

}