package practice;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Program Files/Google Chrome V.104 webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option = new Select(dropdown);

        //selectByValue
        option.selectByValue("1");
        WebElement selected = option.getFirstSelectedOption();
        String selectedOption = selected.getText();
        Assert.assertEquals("Option 1", selectedOption);
        System.out.println("Selected Option: "+ selectedOption);

        //selectByVisibleText
        option.selectByVisibleText("Option 2");
        selected = option.getFirstSelectedOption();
        selectedOption = selected.getText();
        Assert.assertEquals("Option 2", selectedOption);
        System.out.println("Selected Option: "+ selectedOption);

        //selectByIndex         ---NOT WORKING ???---
       /*option.selectByIndex(1);
        selected = option.getFirstSelectedOption();
        selectedOption = selected.getText();
        Assert.assertEquals("Option 2", selectedOption);
        System.out.println("Selected Option: "+ selectedOption);*/

        System.out.println("SUCCESS");
        driver.quit();

    }
}
