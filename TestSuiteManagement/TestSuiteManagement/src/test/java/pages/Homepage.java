package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    WebDriver driver;

    // ✅ Constructor to accept WebDriver
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void openHomePage() {
        driver.get("https://www.amazon.com/");
    }

    public void searchItem(String item) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
}
