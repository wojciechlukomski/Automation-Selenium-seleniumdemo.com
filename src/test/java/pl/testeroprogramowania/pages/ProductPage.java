package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    @FindBy(name = "add-to-cart")
    WebElement addToCartButton;
    
    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewVartButton;
    
    private final WebDriverWait wait;
    private final WebDriver driver;
    
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
        this.driver = driver;
    }
    
    public ProductPage addProductToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        return this;
    }
    
    public CartPage viewCart(){
        wait.until(ExpectedConditions.visibilityOf(viewVartButton));
        viewVartButton.click();
        return new CartPage(driver, wait);
    }
}
