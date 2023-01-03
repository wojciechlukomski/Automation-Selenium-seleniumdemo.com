package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderDetailsPage {
    
    public OrderDetailsPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
    }
}
