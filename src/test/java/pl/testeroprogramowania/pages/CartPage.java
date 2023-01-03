package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utills.SeleniumHelper;

public class CartPage {
    
    private final WebDriver driver;
    private final Actions actions;
    
    @FindBy(xpath = "//*[@id='page-5']/div/section/div/div/div[2]/div/div/a")
    private WebElement proceedToCheckoutButton;
    
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    
    public AddressDetails openAddressDetails() throws InterruptedException {
        SeleniumHelper.waitForClickable(proceedToCheckoutButton, driver);
        actions.moveToElement(proceedToCheckoutButton);
//        Thread.sleep(1000);
        proceedToCheckoutButton.click();
        
        return new AddressDetails(driver);
    }
}
