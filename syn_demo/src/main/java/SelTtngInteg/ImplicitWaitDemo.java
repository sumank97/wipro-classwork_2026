package SelTtngInteg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo
{
    public static void main(String[] args) throws Exception
    {
        WebDriver driver =
                new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/dynamic-properties");

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(6000);

        driver.findElement(By.id("enableAfter"))
                .click();

        System.out.println("Button Clicked Successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}