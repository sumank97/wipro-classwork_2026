
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParaBankLogin
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.name("username"))
                .sendKeys("suman123");

        driver.findElement(By.name("password"))
                .sendKeys("K9r54tbu@12345");

        driver.findElement(By.xpath("//input[@value='Log In']"))
                .click();

        System.out.println("Login Successful");

        Thread.sleep(5000);

        driver.quit();
    }
}