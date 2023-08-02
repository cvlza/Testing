package practice;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class handleAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Program Files/Google Chrome V.104 webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        //handle Alert 1        --does not work when all handle is run (only either handle 1 or handle2,3,4)
        driver.findElement(By.xpath("//*[@id='alertButton']")).click();
        Alert alert1 = driver.switchTo().alert();
        String alert1Message = alert1.getText();
        System.out.println("Alert Message 1: " + alert1Message);
        driver.switchTo().defaultContent();
        System.out.println("Alert 1 successful");

        //handle Alert 2
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        String alert2Message = alert2.getText();
        System.out.println("Alert Message 2: " + alert2Message);
        alert2.accept();
        driver.switchTo().defaultContent();
        System.out.println("Alert 2 successful");

        //handle Alert 3
        driver.navigate().refresh();
        WebElement button = driver.findElement(By.xpath("//*[@id='confirmButton']"));
        button.click();
        Alert alert3 = driver.switchTo().alert();
        String alert3Message = alert3.getText();
        System.out.println("Alert Message 3: " + alert3Message);
        alert3.dismiss();
        driver.switchTo().defaultContent();
        String message = driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
        Assert.assertTrue(message.contains("Cancel"));
        button.click();
        alert3 = driver.switchTo().alert();
        alert3.accept();
        driver.switchTo().defaultContent();
        message = driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
        Assert.assertTrue(message.contains("Ok"));
        System.out.println("Alert 3 successful");

        //handle Alert 4
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='promtButton']")).click();
        Alert alert4 = driver.switchTo().alert();
        String text = "test";
        alert4.sendKeys(text);
        alert4.accept();
        String promptMessage = driver.findElement(By.xpath("//*[@id='promptResult']")).getText();
        Assert.assertTrue(promptMessage.contains(text));
        driver.findElement(By.xpath("//*[@id='promtButton']")).click();
        alert4 = driver.switchTo().alert();
        alert4.sendKeys(text);
        alert4.dismiss();
        System.out.println("Alert 4 successful");

        System.out.println("SUCCESS");
        driver.quit();

    }
}
