package pl.testeroprogramowania.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.LoggedUserPage;
import pl.testeroprogramowania.utills.SeleniumHelper;

public class LoginTest extends BaseTest {
    
    LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
    
    @Test
    public void validLoginUserTest() {
        WebElement logout = new HomePage(driver)
                .openMyAccountPage()
                .validLoginIn("test1@test.pl", "test123456@test123456.pl")
                .getLogoutLink();
        
        SeleniumHelper.waitForClickable(loggedUserPage.getLogoutLink(),driver);
        Assert.assertEquals(logout.getText(), "Logout");
    }
    
    @Test
    public void invalidLoginUserTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .invalidLoginIn("wojtek@test.pl", "test123456@test123456.pl")
                .getError();
        
        SeleniumHelper.waitForClickable(By.xpath("//ul[@class='woocommerce-error']//li"),driver);
        Assert.assertTrue(error.getText().contains("Incorrect username or password."), "Expected text doesn't match!");
    }
}
