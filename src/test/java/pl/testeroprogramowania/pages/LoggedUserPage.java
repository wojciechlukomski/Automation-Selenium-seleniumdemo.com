package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedUserPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        this.wait=wait;
    }
    
    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;
    
    
    public WebElement getDashboardLink(){
        return dashboardLink;
    }
}
