package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartCount() {
        String count = driver.findElement(By.id("nav-cart-count")).getText();
        return Integer.parseInt(count);
    }
}
