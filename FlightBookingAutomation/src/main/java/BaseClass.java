import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
    public static WebDriver driver;

    public void setup()
    {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://blazedemo.com");
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}