import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoAutomation
{
    public static void main(String[] args) throws InterruptedException
    {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--guest");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com");

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("user-name")));

        username.sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("item_4_title_link")));

        product.click();

        Thread.sleep(2000);

        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Add to cart')]")));

        addToCart.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("shopping_cart_link"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("first-name")))
                .sendKeys("Suman");

        driver.findElement(By.id("last-name"))
                .sendKeys("Kumar");

        driver.findElement(By.id("postal-code"))
                .sendKeys("560001");

        driver.findElement(By.id("continue")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("finish"))).click();

        System.out.println("Checkout Completed Successfully");

        Thread.sleep(5000);

        driver.quit();
    }
}