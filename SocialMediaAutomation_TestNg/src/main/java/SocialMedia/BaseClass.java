package SocialMedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass
{
    public static WebDriver driver;

    @BeforeTest
    public void setup()
    {
        ChromeOptions options =
                new ChromeOptions();

        options.addArguments("--disable-notifications");

        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        driver.get("https://www.linkedin.com/login");
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();

        System.out.println("Browser Closed");
    }
}
