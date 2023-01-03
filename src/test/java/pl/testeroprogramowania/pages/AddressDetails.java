package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.testeroprogramowania.models.Customer;

public class AddressDetails {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;
    
    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;
    
    @FindBy(id = "billing_country")
    private WebElement countryInput;
    
    @FindBy(id = "billing_address_1")
    private WebElement addressInput;
    
    @FindBy(id = "billing_address_2")
    private WebElement addressInput2;
    
    @FindBy(id = "billing_postcode")
    private WebElement postalcodeInput;
    
    @FindBy(id = "billing_city")
    private WebElement cityInput;
    
    @FindBy(id = "billing_phone")
    private WebElement phoneInput;
    
    @FindBy(id = "billing_email")
    private WebElement emailInput;
    
    @FindBy(id = "place_order")
    private WebElement placeOrderButton;
    
    @FindBy(id = "order_comments")
    private WebElement commentsInput;
    
    public AddressDetails(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }
    
    public OrderDetailsPage fillAddressDetails(Customer customer, String comments) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        Select select = new Select(countryInput);
        select.selectByVisibleText(customer.getCountry());
        addressInput.sendKeys(customer.getStreet());
        addressInput2.sendKeys(customer.getHouseNumber());
        postalcodeInput.sendKeys(customer.getZipcode());
        cityInput.sendKeys(customer.getCity());
        phoneInput.sendKeys(customer.getPhone());
        emailInput.sendKeys(customer.getEmail());
        commentsInput.sendKeys(comments);
        placeOrderButton.click();
        
        return new OrderDetailsPage(driver, wait);
    }
}
