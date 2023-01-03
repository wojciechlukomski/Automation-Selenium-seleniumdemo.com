package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    
    private final WebDriver driver;
    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;
    
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }
    
    public ProductListPage openProductListPage() {
        shopLink.click();
        return new ProductListPage(driver);
    }
}
