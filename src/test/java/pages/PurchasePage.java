package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PurchasePage {

    WebDriver driver;
    WebDriverWait wait;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zip = By.id("zipCode");
    By cardNumber = By.id("creditCardNumber");
    By month = By.id("creditCardMonth");
    By year = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");
    By purchaseBtn = By.xpath("//input[@value='Purchase Flight']");

    public void bookFlight(String nameVal, String addressVal, String cityVal,
                           String stateVal, String zipVal, String cardVal,
                           String monthVal, String yearVal, String cardNameVal) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(name));

        driver.findElement(name).sendKeys(nameVal);
        driver.findElement(address).sendKeys(addressVal);
        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(state).sendKeys(stateVal);
        driver.findElement(zip).sendKeys(zipVal);
        driver.findElement(cardNumber).sendKeys(cardVal);

        driver.findElement(month).clear();
        driver.findElement(month).sendKeys(monthVal);

        driver.findElement(year).clear();
        driver.findElement(year).sendKeys(yearVal);

        driver.findElement(nameOnCard).sendKeys(cardNameVal);

        driver.findElement(purchaseBtn).click();
    }
}