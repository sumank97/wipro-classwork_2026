public class FlightBookingTest
{
    public static void main(String[] args)
            throws Exception
    {
        BaseClass base =
                new BaseClass();

        base.setup();

        FlightSearchPage search =
                new FlightSearchPage();

        search.searchFlights();

        Thread.sleep(3000);

        BookingPage booking =
                new BookingPage();

        booking.bookTicket();

        Thread.sleep(5000);

        base.closeBrowser();
    }
}