package automationpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo
{
    public static void main(String[] args) throws Exception
    {
        ChromeOptions options =
                new ChromeOptions();

        options.addArguments("--disable-notifications");

        options.addArguments("--incognito");

        options.addArguments("--guest");

        options.setExperimentalOption(
                "excludeSwitches",
                new String[]{"enable-automation"});

        options.setExperimentalOption(
                "prefs",
                java.util.Map.of(
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false));

        WebDriver driver =
                new ChromeDriver(options);

        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.get("https://www.saucedemo.com/");

        Thread.sleep(3000);

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        Thread.sleep(2000);

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        Thread.sleep(2000);

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login Successful");

        Thread.sleep(5000);

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        WebElement addToCart =
                wait.until(
                        ExpectedConditions
                                .elementToBeClickable(
                                        By.id("add-to-cart-sauce-labs-backpack")));

        Thread.sleep(3000);

        addToCart.click();

        System.out.println("Product Added To Cart");

        Thread.sleep(5000);

        driver.findElement(By.className("shopping_cart_link"))
                .click();

        System.out.println("Cart Opened");

        Thread.sleep(5000);

        driver.quit();
    }
}