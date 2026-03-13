package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.FlightsPage;
import pages.PurchasePage;

public class FlightBookingTest extends BaseTest {

    @Test
    public void bookFlightTest(){

        //Home Page
        HomePage home = new HomePage(driver);
        home.selectCities();
       
       
        FlightsPage flights = new FlightsPage(driver);
        flights.selectFlight();
       
        
        PurchasePage purchase = new PurchasePage(driver);
        purchase.bookFlight();
      
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement confirmation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Thank you for your purchase')]")));
        Assert.assertTrue(confirmation.getText().contains("Thank you for your purchase"));
       

        System.out.println("Congratulations!,Flight Booked Successfully");
    }
}