package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SortingStep {
    WebDriver driver;

    @Given("User opens SauceDemo site")
    public void user_opens_saucedemo_site(){
        System.setProperty("webdriver.chrome.driver", "/Program Files/Google Chrome V.104 webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @When("User enters valid credentials")


    @Then("User will be navigated to Dashboard")
    public void user_will_navigated_to_dashboard(){
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Products", title);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", url);
        boolean isCartDisplayed = driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).isDisplayed();
        Assert.assertTrue(isCartDisplayed);
    }

    @Then("User closes the browser")
    public void user_closes_the_browser(){
        driver.quit();
    }

}
