package practice;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class checkbox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Program Files/Google Chrome V.104 webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //Click checkbox1 if not selected
        WebElement checkboxElement1 = driver.findElement((By.xpath("//*[@id='checkboxes']/input[1]")));
        boolean isSelected = checkboxElement1.isSelected();
        System.out.println("Checkbox1 is selected: "+ isSelected);
        if(isSelected == false){
            checkboxElement1.click();
        }
        isSelected = checkboxElement1.isSelected();
        Assert.assertTrue(isSelected);
        System.out.println("Checkbox1 selected");

        //Click checkbox2 if not selected
        WebElement checkboxElement2 = driver.findElement((By.xpath("//*[@id='checkboxes']/input[2]")));
        isSelected = checkboxElement2.isSelected();
        System.out.println("Checkbox2 is selected: "+ isSelected);
        if(isSelected == false){
            checkboxElement2.click();
        }
        isSelected = checkboxElement2.isSelected();
        Assert.assertTrue(isSelected);
        System.out.println("Checkbox2 selected");

        driver.quit();
    }
}
