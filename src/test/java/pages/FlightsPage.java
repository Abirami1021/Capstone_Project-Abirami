package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FlightsPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By chooseFlight = By.xpath("(//input[@value='Choose This Flight'])[1]");

    public void selectFlight() {

        wait.until(ExpectedConditions.elementToBeClickable(chooseFlight));
        driver.findElement(chooseFlight).click();
    }
}