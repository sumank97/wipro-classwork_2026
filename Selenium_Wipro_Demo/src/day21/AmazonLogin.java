package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLogin
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        
        driver.findElement(By.id("nav-link-accountList")).click();

        Thread.sleep(2000);

        
        driver.findElement(By.id("cvfEmail"))
              .sendKeys("skj843320@gmail");

       
        driver.findElement(By.id("continue")).click();

        Thread.sleep(2000);

       
        driver.findElement(By.id("ap_password"))
              .sendKeys("K9r54tbu@12345");

      
        driver.findElement(By.id("signInSubmit")).click();

        Thread.sleep(3000);

        System.out.println(driver.getTitle());

        driver.quit();
    }
}
