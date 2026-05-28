package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo
{
    @DataProvider(name = "loginData")
    public Object[][] getData()
    {
        return new Object[][]
        {
            {"admin", "admin123"},
            {"user", "user123"},
            {"test", "test123"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password)
            throws InterruptedException
    {
        WebDriver driver =
                new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.id("password"))
                .sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.id("login-button"))
                .click();
        Thread.sleep(3000);
        System.out.println(
                "Login Tested With : "
                        + username
                        + " | "
                        + password);

        Thread.sleep(3000);

        driver.quit();
    }
}