package SelTtngInteg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadSleepDemo
{
    public static void main(String[] args) throws Exception
    {
        WebDriver driver =
                new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/dynamic-properties");

        Thread.sleep(5000);

        driver.findElement(By.id("enableAfter"))
                .click();

        System.out.println("Button Clicked");

        Thread.sleep(3000);

        driver.quit();
    }
}