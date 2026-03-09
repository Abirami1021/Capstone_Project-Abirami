package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.FlightsPage;
import pages.PurchasePage;

public class FlightBookingTest extends BaseTest {

    @Test
    public void bookFlightTest() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.selectCities();

        Thread.sleep(2000);   // wait 2 seconds

        FlightsPage flights = new FlightsPage(driver);
        flights.selectFlight();

        Thread.sleep(2000);   // wait 2 seconds

        PurchasePage purchase = new PurchasePage(driver);
        purchase.bookFlight();

        Thread.sleep(5000);   // wait 5 seconds ,so see result

        String confirmation = driver.getPageSource();
        Assert.assertTrue(confirmation.contains("Thank you for your purchase"));
    }
}