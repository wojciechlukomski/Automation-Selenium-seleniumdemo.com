package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.testeroprogramowania.utills.DriverFactory;

import java.time.Duration;

public class BaseTest {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
