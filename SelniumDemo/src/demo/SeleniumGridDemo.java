package demo;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridDemo
{
    public static void main(String[] args)
            throws Exception
    {
        ChromeOptions options =
                new ChromeOptions();

        WebDriver driver =
                new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        options);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login Successful");

        Thread.sleep(3000);

        driver.quit();
    }
}