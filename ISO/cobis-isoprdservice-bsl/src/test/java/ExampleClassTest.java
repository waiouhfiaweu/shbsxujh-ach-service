import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class ExampleClassTest {

    @BeforeAll
    public static void setUpRequest() {
    }

    boolean pass() {
        return true;
    };
    @Test
    void getExampleTest() {
        assertTrue("This will succeed.", pass());
    }
}
