import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLogin
{
    public static void main(String[] args)
            throws Exception
    {
        WebDriver driver =
                new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(25));

        driver.get("https://www.amazon.in");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("nav-link-accountList")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ap_email_login")))
                .sendKeys("skj843320@gmail.com");

        driver.findElement(By.id("continue"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("ap_password")))
                .sendKeys("K9r54tbu@12345");

        driver.findElement(By.id("signInSubmit"))
                .click();

        Thread.sleep(5000);

        WebElement searchBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")));

        searchBox.sendKeys("gaming laptop");

        driver.findElement(By.id("nav-search-submit-button"))
                .click();

        Thread.sleep(6000);

        WebElement firstProduct =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("(//h2/a)[1]")));   // BEST FIX

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", firstProduct);

        Thread.sleep(2000);

        firstProduct.click();
        
        
        WebElement addToCart =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("add-to-cart-button")));

        js.executeScript("arguments[0].click();", addToCart);

        System.out.println(
                "Gaming Laptop Added To Cart Successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}