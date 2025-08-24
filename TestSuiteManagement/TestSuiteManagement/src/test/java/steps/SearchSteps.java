package steps;
  // ✅ "Steps" ऐवजी lowercase ठेवा (Java convention)

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// आवश्यक imports
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.Homepage;
import pages.ProductPage;
import pages.ResultsPage;

public class SearchSteps {
    WebDriver driver;
    Homepage home;
    ResultsPage results;
    ProductPage product;
    CartPage cart;

    @Given("I am on Amazon homepage")
    public void i_am_on_amazon_homepage() {
        // ✅ Driver initialize
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Pages initialize with driver
        home = new Homepage(driver);
        results = new ResultsPage(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);

        // ✅ open homepage
        home.openHomePage();
    }

    @When("I search for {string}")
    public void i_search_for(String item) {
        home.searchItem(item);
    }

    @When("I select the first product from results")
    public void i_select_first_product() {
        results.clickFirstProduct();
    }

    @When("I add the product to the cart")
    public void i_add_to_cart() {
        product.addToCart();
    }

    @Then("^The cart should contain (\\d+) item$")
    public void cart_should_contain_item(int expectedCount) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cartCountElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(ById.id("nav-cart-count"))
        );

        int actualCount = Integer.parseInt(cartCountElement.getText().trim());
        Assert.assertEquals(expectedCount, actualCount);
    }

}
