package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By myAccount = By.xpath("//span[text()='My Account']");
    By login = By.linkText("Login");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginBtn = By.xpath("//input[@value='Login']");

    public void loginApplication() {

        driver.findElement(myAccount).click();

        driver.findElement(login).click();

        driver.findElement(email).sendKeys("test@gmail.com");

        driver.findElement(password).sendKeys("test123");

        driver.findElement(loginBtn).click();
    }
}