package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonNavigate
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

     
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        searchBox.sendKeys("Skinn Titan Perfume");

       
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
                ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));

        addToCart.click();

        System.out.println("Product added to cart successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}