package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    
    private final WebDriver driver;
    
    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;
    
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;
    
    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    public WebElement getDashboardLink() {
        return dashboardLink;
    }
    
    public WebElement getLogoutLink() {
        return logoutLink;
    }
}
