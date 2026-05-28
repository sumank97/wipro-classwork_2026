package day23;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParaBankTest
{
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test(priority = 1)
    public void verifyTitle()
    {
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,
                "ParaBank | Welcome | Online Banking");

        System.out.println("Title Validation Passed");
    }

    @Test(priority = 2)
    public void loginTest() throws Exception
    {
        driver.findElement(By.name("username"))
                .sendKeys("john");

        driver.findElement(By.name("password"))
                .sendKeys("demo");

        driver.findElement(By.xpath("//input[@value='Log In']"))
                .click();

        Thread.sleep(3000);

        System.out.println("Login Successful");
    }

    @Test(priority = 3)
    public void openAccountOverview() throws Exception
    {
        driver.findElement(By.linkText("Accounts Overview"))
                .click();

        Thread.sleep(3000);

        System.out.println("Accounts Overview Opened");
    }

    @Test(priority = 4)
    public void transferFunds() throws Exception
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Transfer Funds"))).click();

        Thread.sleep(2000);

        driver.findElement(By.id("amount"))
                .sendKeys("100");

        driver.findElement(By.xpath("//input[@value='Transfer']"))
                .click();

        Thread.sleep(3000);

        System.out.println("Funds Transfer Completed");
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();

        System.out.println("Browser Closed");
    }
}