package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zip = By.id("zipCode");
    By cardType = By.id("cardType");
    By cardNumber = By.id("creditCardNumber");
    By month = By.id("creditCardMonth");
    By year = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");
    By purchaseBtn = By.xpath("//input[@value='Purchase Flight']");

    public void bookFlight() throws InterruptedException {

        driver.findElement(name).sendKeys("Abirami");
        Thread.sleep(2000);

        driver.findElement(address).sendKeys("106/2,Coimbatore");
        Thread.sleep(2000);

        driver.findElement(city).sendKeys("Coimbatore");
        Thread.sleep(2000);

        driver.findElement(state).sendKeys("TN");
        Thread.sleep(2000);

        driver.findElement(zip).sendKeys("627814");
        Thread.sleep(2000);

        driver.findElement(cardNumber).sendKeys("9876543210");
        Thread.sleep(2000);

        driver.findElement(month).clear();
        driver.findElement(month).sendKeys("3");
        Thread.sleep(2000);

        driver.findElement(year).clear();
        driver.findElement(year).sendKeys("2026");
        Thread.sleep(2000);

        driver.findElement(nameOnCard).sendKeys("Abirami");
        Thread.sleep(2000);

        driver.findElement(purchaseBtn).click();
    }
}