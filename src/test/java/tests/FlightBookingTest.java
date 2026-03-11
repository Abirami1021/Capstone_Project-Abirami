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

        //Home Page
        HomePage home = new HomePage(driver);
        home.selectCities();// Select departure and destination 
        Thread.sleep(2000);
       
        FlightsPage flights = new FlightsPage(driver); //Flights Page
        flights.selectFlight();// Select first available flight
        Thread.sleep(2000);
        
        PurchasePage purchase = new PurchasePage(driver);//Purchase Page
        purchase.bookFlight();
        Thread.sleep(2000);

        String confirmation = driver.getPageSource();//Verify confirmation message

        Assert.assertTrue(
                confirmation.contains("Thank you for your purchase"),
                "Flight booking failed!"
        );

        System.out.println("Flight Booking Successful");
    }
}