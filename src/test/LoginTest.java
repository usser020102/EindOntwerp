import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


class LoginTest {

    @Test
    void login() {
        Login test = new Login();
        assertTrue(test.Login("admin", "abc123"));
        assertFalse(test.Login("test", "abc123"));
        assertFalse(test.Login("admin", "123456"));
        assertFalse(test.Login("test", "123456"));

    }
}