package SocialMedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends BaseClass
{
    @Test(priority = 1)
    public void login() throws Exception
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(30));

        WebElement email =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.name("session_key")));

        email.sendKeys("demo.skj57001@gmail.com");

        WebElement password =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.name("session_password")));

        password.sendKeys("K9r54tbu@123");

        Thread.sleep(3000);

        driver.findElement(
                By.xpath("//button[@type='submit']"))
                .click();

        System.out.println("Login Successful");
    }
}