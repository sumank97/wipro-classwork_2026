import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends BaseClass
{
    By sourceCity =
            By.name("fromPort");

    By destinationCity =
            By.name("toPort");

    By findFlightsButton =
            By.xpath("//input[@value='Find Flights']");

    public void searchFlights()
            throws Exception
    {
        Select from =
                new Select(driver.findElement(sourceCity));

        from.selectByVisibleText("Boston");

        Select to =
                new Select(driver.findElement(destinationCity));

        to.selectByVisibleText("London");

        Thread.sleep(2000);

        driver.findElement(findFlightsButton)
                .click();

        System.out.println(
                "Flight Search Successful");
    }
}