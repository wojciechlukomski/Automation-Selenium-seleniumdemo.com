package pl.testeroprogramowania.tests;

import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;
import pl.testeroprogramowania.utills.SeleniumHelper;

public class CheckoutTest extends BaseTest {
    
    @Test
    public void checkoutTest() throws InterruptedException {
        
        Customer customer = new Customer();
        String productTitle = "Java Selenium WebDriver";
    
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openProductListPage()
                .openProduct(productTitle)
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer, "Some descriptions");
    
        SeleniumHelper.waitForClickable(orderDetailsPage.getMessage(),driver);
        
        Assert.assertEquals(orderDetailsPage.getMessage().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductDetails().getText(),productTitle);
    }
}
