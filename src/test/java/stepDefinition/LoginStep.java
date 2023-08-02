package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginStep {
    WebDriver driver;

    @Given("User is in SauceDemo Login Page")
    public void user_is_in_saucedemo_login_page(){
        System.setProperty("webdriver.chrome.driver", "/Program Files/Google Chrome V.104 webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @When("User enters {string} and {string}") //In Feature file User enters "standard_user" and "secret_sauce"
    public void user_enters_and(String username, String password){
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @When("^User enters ([^\"]*) and ([^\"]*)$")    //Data driven table in feature file User enters <...> and <...>
    public void user_enters_username_password(String username, String password){
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @Then("User is login successfully")
    public void user_is_login_successfully(){
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Products", title);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", url);
        boolean isCartDisplayed = driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).isDisplayed();
        Assert.assertTrue(isCartDisplayed);
    }

    @And("User closes browser")
    public void user_closes_browser(){
        System.out.println("Login Successful");
        driver.quit();
    }
}
