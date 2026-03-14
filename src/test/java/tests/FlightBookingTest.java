package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.FlightsPage;
import pages.PurchasePage;

public class FlightBookingTest extends BaseTest {

    @DataProvider(name="bookingData")
    public Object[][] getData(){
        return new Object[][]{
         {"Paris","London","Abirami","106/2 Coimbatore","Coimbatore","TN","627814","9876543210","3","2026","Abirami"},
         {"Boston","Berlin","Kavi","12 Street","Chennai","TN","75001","1234567890","5","2027","Kavi"},
         {"San Diego","New York","Pravee","45 Road","Bangalore","KA","560001","9871234567","6","2028","Pravee"}
        };
    }

    @Test(dataProvider="bookingData")
    public void bookFlightTest(String fromCity,String toCity,
                               String name,String address,String city,
                               String state,String zip,String card,
                               String month,String year,String cardName){

        HomePage home = new HomePage(driver);
        home.selectCities(fromCity,toCity);

        FlightsPage flights = new FlightsPage(driver);
        flights.selectFlight();

        PurchasePage purchase = new PurchasePage(driver);
        purchase.bookFlight(name,address,city,state,zip,card,month,year,cardName);

        String str = driver.getPageSource();

        // Negative case
        if(name.isEmpty()){
            System.out.println("Negative Test Case Executed");
            Assert.assertFalse(str.contains("Thank you for your purchase"));
        }

        // Positive cases
        else{
            Assert.assertTrue(str.contains("Thank you for your purchase"));
            System.out.println("Positive Test Case Passed");
        }
    }
}