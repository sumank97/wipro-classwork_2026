package flightbooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass
{
    public WebDriver driver;

    @BeforeTest
    public void setup()
    {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://blazedemo.com/");
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();

        System.out.println("Browser Closed");
    }
}