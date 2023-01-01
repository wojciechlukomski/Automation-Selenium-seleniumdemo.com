package pl.testeroprogramowania.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {
    
    @Test
    public void RegisterUserTest() throws InterruptedException {
        int random = (int) (Math.random() * 1000);
        WebElement dashboardLink = new HomePage(driver, wait).openMyAccountPage()
                .registerValidDataUser("test" + random + "@test.pl", "test123456@test123456.pl")
                .getDashboardLink();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
        
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }
    
    @Test
    public void RegisterUserTestWithExistingEmail() throws InterruptedException {
        int random = (int) (Math. random() * 1000);
        WebElement error = new HomePage(driver, wait).openMyAccountPage()
                .registerInvalidDataUser("test1@test.pl", "test123456@test123456.pl")
                .getError();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='woocommerce-error']//li")));
        Thread.sleep(1000);
        
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));
    }
}
