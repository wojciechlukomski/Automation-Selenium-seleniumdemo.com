package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utills.SeleniumHelper;

public class MyAccountPage {
    
    private final Actions actions;
    private final WebDriver driver;
    
    @FindBy(css = "#reg_email")
    private WebElement regEmail;
    
    @FindBy(css = "#reg_password")
    private WebElement regPassword;
    
    @FindBy(css = "#username")
    private WebElement usernameInput;
    
    @FindBy(css = "#password")
    private WebElement passwordInput;
    
    @FindBy(name = "register")
    private WebElement registerButton;
    
    @FindBy(name = "login")
    private WebElement loginButton;
    
    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;
    
    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    
    public WebElement getError() {
        return error;
    }
    
    public LoggedUserPage registerValidDataUser(String email, String password) throws InterruptedException {
        repetitiveRegisterFillUp(email, password);
        return new LoggedUserPage(driver);
    }
    
    public MyAccountPage registerInvalidDataUser(String email, String password) throws InterruptedException {
        repetitiveRegisterFillUp(email, password);
        return this;
    }
    
    public void repetitiveRegisterFillUp(String email, String password) throws InterruptedException {
        SeleniumHelper.waitForClickable(registerButton, driver);
        regEmail.sendKeys(email);
        regPassword.sendKeys(password);
        Thread.sleep(1000);
        actions.moveToElement(registerButton).click().perform();
    }
    
    public void repetitiveLoginFillUp(String username, String password) {
        SeleniumHelper.waitForClickable(loginButton, driver);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        actions.moveToElement(loginButton).click().perform();
    }
    
    public LoggedUserPage validLoginIn(String username, String password) {
        repetitiveLoginFillUp(username, password);
        return new LoggedUserPage(driver);
    }
    
    public MyAccountPage invalidLoginIn(String username, String password) {
        repetitiveLoginFillUp(username, password);
        return this;
    }
}

