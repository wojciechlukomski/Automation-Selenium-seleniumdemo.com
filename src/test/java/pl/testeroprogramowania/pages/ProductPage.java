package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pl.testeroprogramowania.utills.SeleniumHelper.waitForClickable;

public class ProductPage {
    private final WebDriver driver;
    
    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;
    
    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCartButton;
    
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    public ProductPage addProductToCart() {
//        waitForClickable(addToCartButton, driver);
        addToCartButton.click();
        return this;
    }
    
    public CartPage viewCart() {
        waitForClickable(viewCartButton, driver);
        viewCartButton.click();
        return new CartPage(driver);
    }
}
