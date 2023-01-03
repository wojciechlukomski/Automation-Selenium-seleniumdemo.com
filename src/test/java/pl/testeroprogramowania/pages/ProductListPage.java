package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListPage {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    @FindBy(xpath = "//h2[text()='Java Selenium WebDriver']")
    WebElement seleniumWebDriverCourse;
    
    public ProductListPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }
    
    public ProductPage openProduct(String title) {
        wait.until(ExpectedConditions.visibilityOf(seleniumWebDriverCourse));
        driver.findElement(By.xpath("//h2[text()='" + title + "']")).click();
        return new ProductPage(driver, wait);
    }
}
