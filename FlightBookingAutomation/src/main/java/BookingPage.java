import org.openqa.selenium.By;

public class BookingPage extends BaseClass
{
    By chooseFlight =
            By.xpath("(//input[@value='Choose This Flight'])[1]");

    By name =
            By.id("inputName");

    By address =
            By.id("address");

    By city =
            By.id("city");

    By state =
            By.id("state");

    By zipCode =
            By.id("zipCode");

    By cardType =
            By.id("cardType");

    By creditCardNumber =
            By.id("creditCardNumber");

    By creditCardMonth =
            By.id("creditCardMonth");

    By creditCardYear =
            By.id("creditCardYear");

    By nameOnCard =
            By.id("nameOnCard");

    By purchaseButton =
            By.xpath("//input[@value='Purchase Flight']");

    public void bookTicket()
            throws Exception
    {
        driver.findElement(chooseFlight)
                .click();

        Thread.sleep(3000);

        driver.findElement(name)
                .sendKeys("Suman");

        driver.findElement(address)
                .sendKeys("BTM Layout");

        driver.findElement(city)
                .sendKeys("Bangalore");

        driver.findElement(state)
                .sendKeys("Karnataka");

        driver.findElement(zipCode)
                .sendKeys("560001");

        driver.findElement(creditCardNumber)
                .sendKeys("123456789");

        driver.findElement(creditCardMonth)
                .clear();

        driver.findElement(creditCardMonth)
                .sendKeys("12");

        driver.findElement(creditCardYear)
                .clear();

        driver.findElement(creditCardYear)
                .sendKeys("2028");

        driver.findElement(nameOnCard)
                .sendKeys("Suman Kumar");

        Thread.sleep(2000);

        driver.findElement(purchaseButton)
                .click();

        System.out.println(
                "Flight Ticket Booked Successfully");
    }
}