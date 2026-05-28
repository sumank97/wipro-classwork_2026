import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParaBankRegister
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.linkText("Register")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("customer.firstName"))
                .sendKeys("Suman");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.lastName"))
                .sendKeys("Kumar");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.address.street"))
                .sendKeys("BTM Layout");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.address.city"))
                .sendKeys("Bangalore");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.address.state"))
                .sendKeys("Karnataka");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.address.zipCode"))
                .sendKeys("560001");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.phoneNumber"))
                .sendKeys("7488236338");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.ssn"))
                .sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.username"))
                .sendKeys("suman123");
        Thread.sleep(2000);
        driver.findElement(By.id("customer.password"))
                .sendKeys("K9r54tbu@12345");
        Thread.sleep(2000);
        driver.findElement(By.id("repeatedPassword"))
                .sendKeys("K9r54tbu@12345");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Register']"))
                .click();
        Thread.sleep(2000);
        System.out.println("Registration Successful");

        Thread.sleep(2000);

        driver.quit();
    }
}