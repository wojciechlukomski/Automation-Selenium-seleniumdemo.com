package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedUserPage {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;
    
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;
    
    public LoggedUserPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement getDashboardLink() {
        return dashboardLink;
    }
    
    public WebElement getLogoutLink() {
        return logoutLink;
    }
}
