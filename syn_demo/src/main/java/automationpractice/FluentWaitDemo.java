package automationpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitDemo
{
    public static void main(String[] args)
    {
        WebDriver driver =
                new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");

        FluentWait<WebDriver> wait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(Exception.class);

        WebElement flights =
                wait.until(driver1 ->
                        driver1.findElement(
                                By.xpath("//span[text()='Flights']")));

        flights.click();

        System.out.println("Flight Search Loaded");

        driver.quit();
    }
}