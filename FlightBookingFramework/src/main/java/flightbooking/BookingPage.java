package flightbooking;

import org.openqa.selenium.By;

public class BookingPage extends BaseClass
{
    public void bookFlight() throws Exception
    {
        

        driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[1]"))
                .click();

        Thread.sleep(3000);

     

        driver.findElement(By.id("inputName"))
                .sendKeys("Suman Kumar");

        driver.findElement(By.id("address"))
                .sendKeys("Banglore");

        driver.findElement(By.id("city"))
                .sendKeys("Banglore");

        driver.findElement(By.id("state"))
                .sendKeys("Karnataka");

        driver.findElement(By.id("zipCode"))
                .sendKeys("570001");

        driver.findElement(By.id("creditCardNumber"))
                .sendKeys("1234567890123456");

        driver.findElement(By.id("nameOnCard"))
                .sendKeys("Suman Kumar");

        Thread.sleep(2000);

        

        driver.findElement(By.xpath("//input[@value='Purchase Flight']"))
                .click();

        Thread.sleep(3000);

        System.out.println("Flight Booking Completed");
    }
}