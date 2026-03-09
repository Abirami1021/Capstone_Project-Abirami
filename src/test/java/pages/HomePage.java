package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)   {
        this.driver = driver;
    }

    By departure = By.name("fromPort");
    By destination = By.name("toPort");
    By findFlights = By.xpath("//input[@value='Find Flights']");

    public void selectCities() throws InterruptedException {

        Select dep = new Select(driver.findElement(departure));
        dep.selectByVisibleText("Paris");

        Thread.sleep(2000);
        Select dest = new Select(driver.findElement(destination));
        dest.selectByVisibleText("London");
        
        Thread.sleep(2000);

        driver.findElement(findFlights).click();
    }
}