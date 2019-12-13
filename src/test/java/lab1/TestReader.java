package lab1;

import lab1.model.Reader;
import org.testng.annotations.Test;

public class TestReader {

    @Test
    public void builderTest() {
        Reader reader = new Reader.Builder()
                .setId(1)
                .setFirstName("Вася")
                .setLastName("Мельник")
                .setTelephone("+380508112122")
                .setAddress("вул. Івана Франка, 121")
                .build();
    }

}
