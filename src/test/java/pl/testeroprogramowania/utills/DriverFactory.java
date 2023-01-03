package pl.testeroprogramowania.utills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        
        return new ChromeDriver();
    }
}
