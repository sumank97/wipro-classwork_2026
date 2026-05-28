import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PHPTravelsHotelBooking
{
    public static void main(String[] args) throws Exception
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://phptravels.net/login");
        driver.findElement(By.xpath("//button[contains(text(),'I Understand & Continue')]"))
        .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("email")))
                .sendKeys("user@phptravels.com");

        driver.findElement(By.name("password"))
                .sendKeys("demouser");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(.,'Sign In to your account')]")))
                .click();

        Thread.sleep(3000);

       

        driver.get("https://phptravels.net/");

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
        		By.xpath("//input[@type='search']")))
                .sendKeys("Dubai");

        Thread.sleep(3000);}}