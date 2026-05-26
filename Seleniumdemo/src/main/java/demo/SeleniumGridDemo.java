package demo;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridDemo
{
    public static void main(String[] args) throws Exception
    {
        ChromeOptions options =
                new ChromeOptions();

        
        options.addArguments("--start-maximized");

        WebDriver driver =
                new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        options);

        driver.get("https://www.google.com");

        Thread.sleep(3000);

        System.out.println("Title : "
                + driver.getTitle());

        Thread.sleep(5000);

        driver.quit();

        System.out.println(
                "Selenium Grid Execution Successful");
    }
}