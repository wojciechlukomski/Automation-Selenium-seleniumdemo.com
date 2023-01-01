package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {
    
    @Test
    public void RegisterUserTest() {
        new HomePage(driver).openMyAccountPage();
    }
}
