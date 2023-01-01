package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pl.testeroprogramowania.utills.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
