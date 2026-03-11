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

    public void bookFlight() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        driver.findElement(name).sendKeys("Abirami");
       // Thread.sleep(1500);

        driver.findElement(address).sendKeys("106/2,Coimbatore");
       
        driver.findElement(city).sendKeys("Coimbatore");
        
        driver.findElement(state).sendKeys("TN");
      

        driver.findElement(zip).sendKeys("627814");
       
        driver.findElement(cardNumber).sendKeys("9876543210");
    

        driver.findElement(month).clear();
        driver.findElement(month).sendKeys("3");
       
        driver.findElement(year).clear();
        driver.findElement(year).sendKeys("2026");
       
        driver.findElement(nameOnCard).sendKeys("Abirami");
        
        driver.findElement(purchaseBtn).click();
    }
}