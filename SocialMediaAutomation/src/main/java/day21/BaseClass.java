package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass
{
    public static WebDriver driver;

    public void setup()
    {
        ChromeOptions options =
                new ChromeOptions();

        options.addArguments("--disable-notifications");

        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        driver.get("https://www.linkedin.com/login");
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}