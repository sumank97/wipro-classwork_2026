package demo;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelGridDemo
{
    WebDriver driver;

    @Test

    @Parameters({"browser"})

    public void gridTest(String browser)
            throws Exception
    {
       
        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments(
                    "--start-maximized");

            driver =
                    new RemoteWebDriver(
                            new URL(
                            "http://localhost:4444"),
                            options);
        }

      
        else if(browser.equalsIgnoreCase("edge"))
        {
            EdgeOptions options =
                    new EdgeOptions();

            driver =
                    new RemoteWebDriver(
                            new URL(
                            "http://localhost:4444"),
                            options);
        }


        driver.get(
                "https://www.saucedemo.com/");

       
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println(
                browser +
                " Browser Executed Successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}