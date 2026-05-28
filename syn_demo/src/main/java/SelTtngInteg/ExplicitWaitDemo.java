package SelTtngInteg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo
{
    public static void main(String[] args) throws Exception
    {
        WebDriver driver =
                new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        WebElement button =
                wait.until(
                        ExpectedConditions
                                .elementToBeClickable(
                                        By.id("enableAfter")));

        Thread.sleep(3000);

        button.click();

        System.out.println("Button Clicked Successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}