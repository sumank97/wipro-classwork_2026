package flightbooking;

import org.testng.annotations.Test;

public class FlightBookingTest extends BaseClass
{
    @Test
    public void bookTicket() throws Exception
    {
        FlightSearchPage search =
                new FlightSearchPage();

        search.driver = driver;

        search.searchFlight();

        BookingPage booking =
                new BookingPage();

        booking.driver = driver;

        booking.bookFlight();

        System.out.println("Flight Ticket Booked Successfully");
    }
}