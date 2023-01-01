package pl.testeroprogramowania.utills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    
    public static WebDriver getDriver() {
        WebDriverManager.safaridriver().setup();
        
        return new SafariDriver();
    }
}
