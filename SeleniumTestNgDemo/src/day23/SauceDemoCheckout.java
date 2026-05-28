package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoCheckout
{
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        ChromeOptions options = new ChromeOptions();

        // Disable Chrome password manager popup

        options.addArguments("--disable-notifications");

        options.addArguments("--guest");

        options.setExperimentalOption(
                "prefs",
                new java.util.HashMap<String, Object>()
                {{
                    put("credentials_enable_service", false);
                    put("profile.password_manager_enabled", false);
                }}
        );

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void checkoutTest() throws InterruptedException
    {
        // Login

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login Successful");

        Thread.sleep(3000);

        // Add product to cart

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        System.out.println("Product Added");

        Thread.sleep(2000);

        // Open cart

        driver.findElement(By.className("shopping_cart_link"))
                .click();

        Thread.sleep(2000);

        // Checkout

        driver.findElement(By.id("checkout"))
                .click();

        Thread.sleep(2000);

        // User details

        driver.findElement(By.id("first-name"))
                .sendKeys("Suman");

        driver.findElement(By.id("last-name"))
                .sendKeys("Kumar");

        driver.findElement(By.id("postal-code"))
                .sendKeys("570001");

        Thread.sleep(2000);

        driver.findElement(By.id("continue"))
                .click();

        Thread.sleep(2000);

        driver.findElement(By.id("finish"))
                .click();

        System.out.println("Order Placed Successfully");

        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}