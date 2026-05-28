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

public class SauceDemoCheckout
{
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        ChromeOptions options = new ChromeOptions();

        

        options.addArguments("--incognito");

        options.addArguments("--disable-notifications");

        options.addArguments("--disable-popup-blocking");

        options.addArguments("--guest");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void verifyLoginPageTitle()
    {
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "Swag Labs");

        System.out.println("Title Validation Passed");
    }

    @Test(priority = 2)
    public void loginTest() throws Exception
    {
        

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

      

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");


        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(3000);

        System.out.println("Login Successful");
    }

    @Test(priority = 3)
    public void addProductToCart() throws Exception
    {
       

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        Thread.sleep(2000);

        System.out.println("Product Added To Cart");
    }

    @Test(priority = 4)
    public void openCart() throws Exception
    {
        

        driver.findElement(By.className("shopping_cart_link"))
                .click();

        Thread.sleep(2000);

        System.out.println("Cart Opened");
    }

    @Test(priority = 5)
    public void checkoutProcess() throws Exception
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

     

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout"))).click();

        Thread.sleep(2000);


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

        Thread.sleep(3000);

        System.out.println("Checkout Completed Successfully");
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();

        System.out.println("Browser Closed");
    }
}