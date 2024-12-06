import com.example.devops.SimpleAppDevOps;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SimpleAppDevOpsTest {

    @Test
    public void testLoginWithValidUser() {
        SimpleAppDevOps app = new SimpleAppDevOps();
        // Simulate a valid login (you are not running the GUI here)
        boolean loginSuccess = app.users.containsKey("john") && app.users.get("john").equals("password123");
        assertTrue(loginSuccess, "The login should be successful for a valid user.");
    }

    @Test
    public void testLoginWithInvalidUser() {
        SimpleAppDevOps app = new SimpleAppDevOps();
        // Simulate an invalid login
        boolean loginFail = !app.users.containsKey("invalidUser");
        assertTrue(loginFail, "The login should fail for an invalid user.");
    }
}
