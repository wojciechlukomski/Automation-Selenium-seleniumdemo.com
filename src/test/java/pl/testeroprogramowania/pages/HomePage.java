package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    
    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public HomePage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }
    
    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver, wait);
    }
}
