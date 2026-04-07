package stepdefs;

import bases.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class hooks extends BaseTest {

    @Before
    public void setUp() {
        if (driver != null) {
            getDriver();
        }
    }

    @After
    public void tearDown() {
        close();
    }
}
