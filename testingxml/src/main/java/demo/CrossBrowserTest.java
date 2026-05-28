package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest
{
    WebDriver driver;

    @Test

    @Parameters({"browser","username","password"})

    public void browserTest(String browser,
                            String uname,
                            String pass)
            throws Exception
    {

        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver()
                    .setup();

            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver()
                    .setup();

            driver = new EdgeDriver();
        }

        driver.manage().window()
                .maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys(uname);

        driver.findElement(By.id("password"))
                .sendKeys(pass);

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println(browser +
                " Browser Login Successful");

        Thread.sleep(3000);

        driver.quit();
    }
}