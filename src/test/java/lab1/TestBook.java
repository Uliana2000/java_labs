package lab1;

import lab1.model.Book;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestBook {
    @Test
    public void builderTest() {
        Book book = new Book.Builder()
                .setId(1)
                .setName("Якась книга")
                .setDateIn(LocalDate.of(2019, 10, 2))
                .setDateOut(LocalDate.of(2019, 11, 3))
                .build();
    }
}
