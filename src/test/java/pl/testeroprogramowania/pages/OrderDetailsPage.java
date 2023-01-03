package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderDetailsPage {
    
    private final WebDriver driver;
    
    @FindBy(xpath = "//div//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")
    private WebElement message;
    
    @FindBy(xpath = "//tbody//a")
    private WebElement productDetails;
    
    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    public WebElement getProductDetails() {
        return productDetails;
    }
    
    public WebElement getMessage() {
        return message;
    }
}
