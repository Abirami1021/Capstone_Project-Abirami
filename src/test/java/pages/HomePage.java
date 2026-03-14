package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By departure = By.name("fromPort");
    By destination = By.name("toPort");
    By findFlights = By.xpath("//input[@value='Find Flights']");

    public void selectCities(String fromCity,String toCity) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(departure));

        Select dep = new Select(driver.findElement(departure));
        dep.selectByVisibleText(fromCity);

        wait.until(ExpectedConditions.visibilityOfElementLocated(destination));

        Select dest = new Select(driver.findElement(destination));
        dest.selectByVisibleText(toCity);

        wait.until(ExpectedConditions.elementToBeClickable(findFlights));
        driver.findElement(findFlights).click();
    }
}