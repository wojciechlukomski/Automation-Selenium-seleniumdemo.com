package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;

public class CheckoutTest extends BaseTest {
    
   
    
    @Test
    public void checkoutTest() throws InterruptedException {
    
        Customer customer = new Customer();
        customer.setFirstName("Wojtek");
        customer.setLastName("Luko");
        customer.setCountry("Poland");
        customer.setHouseNumber("14");
        customer.setStreet("Chelmonskiego");
        customer.setZipcode("11111");
        customer.setCity("Krakow");
        customer.setEmail("w@email.com");
        customer.setPhone("500500500");
        
        new HomePage(driver, wait)
                .openProductListPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer,"Some descriptions");
                
    }
}
