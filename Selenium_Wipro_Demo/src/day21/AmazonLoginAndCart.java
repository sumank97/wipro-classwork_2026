package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLoginAndCart
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        
        driver.get("https://www.amazon.in");

       
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("nav-link-accountList"))).click();

        
        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("ap_email_login")));

        email.sendKeys("skj843320@gmail.com");

        
        driver.findElement(By.id("continue")).click();

        
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("ap_password")));

        password.sendKeys("K9r54tbu@12345");

      
        driver.findElement(By.id("signInSubmit")).click();

        
        Thread.sleep(5000);

        
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")));

        searchBox.sendKeys("Skinn By Titan | Verge Perfume - 50 Ml | Perfume For Man | Gift for Men | Premium Fragrance | Grooming Essentials | Long Lasting Smell for Men |Fresh, Woody, Spicy | Eau De Parfum");

       
        driver.findElement(By.id("nav-search-submit-button")).click();

        
        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//span[contains(text(),'SKINN')])[1]")));

        product.click();

       
        for(String windowHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(windowHandle);
        }

      
        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("add-to-cart-button")));

        addToCart.click();

        System.out.println("Product Added To Cart Successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}