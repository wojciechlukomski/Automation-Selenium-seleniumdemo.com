package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utills.SeleniumHelper;

public class ProductListPage {
    
    private final WebDriver driver;
    
    @FindBy(xpath = "//h2[text()='Java Selenium WebDriver']")
    WebElement seleniumWebDriverCourse;
    
    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    public ProductPage openProduct(String title) {
        SeleniumHelper.waitForClickable(By.xpath("//h2[text()='" + title + "']"), driver);
        seleniumWebDriverCourse.click();
        return new ProductPage(driver);
    }
}
