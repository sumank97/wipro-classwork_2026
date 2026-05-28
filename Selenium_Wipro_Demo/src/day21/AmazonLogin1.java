package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLogin1
{
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("nav-link-accountList"))).click();

       
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ap_email_login")));

        email.sendKeys("skj843320@gmail.com");

        
        driver.findElement(By.id("continue")).click();

       
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ap_password")));

        password.sendKeys("K9r54tbu@12345");

        
        driver.findElement(By.id("signInSubmit")).click();

        System.out.println(driver.getTitle());
    }
}
