package flightbooking;

import org.openqa.selenium.By;

public class FlightSearchPage extends BaseClass
{
    public void searchFlight() throws Exception
    {
       

        driver.findElement(By.name("fromPort"))
                .sendKeys("Boston");

     

        driver.findElement(By.name("toPort"))
                .sendKeys("London");

       

        driver.findElement(By.xpath("//input[@value='Find Flights']"))
                .click();

        Thread.sleep(3000);

        System.out.println("Flight Search Completed");
    }
}