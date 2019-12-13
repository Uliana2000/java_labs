package lab4;

import lab4.model.Reader;
import org.testng.annotations.Test;

public class TestReader {

    @Test
    public void testBuilder() {
        Reader reader = new Reader.Builder()
                .setId(1)
                .setAddress("Address")
                .setFirstName("First")
                .setLastName("Last")
                .setTelephone("+380508582522")
                .build();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testNegativeBuilder() {
        Reader reader = new Reader.Builder()
                .setId(null)
                .setAddress("Address")
                .setFirstName(null)
                .setLastName("")
                .setTelephone("+780501582522")
                .build();
    }

}
