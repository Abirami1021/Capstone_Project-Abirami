package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.ScreenshotUtil;
import utils.ExtentReportManager;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {

    public WebDriver driver;

    public static ExtentReports extent =
            ExtentReportManager.getReportInstance();

    public static ExtentTest test;

    @BeforeMethod
    public void setup(ITestResult result){

        test = extent.createTest(result.getMethod().getMethodName());

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result){

        if(result.getStatus() == ITestResult.SUCCESS){
            ScreenshotUtil.captureScreenshot(driver,
                    result.getName()+"_PASS_"+System.currentTimeMillis());

            test.pass("Test Passed");
        }

        if(result.getStatus() == ITestResult.FAILURE){
            ScreenshotUtil.captureScreenshot(driver,
                    result.getName()+"_FAIL_"+System.currentTimeMillis());

            test.fail("Test Failed");
        }

        extent.flush();

        if(driver != null){
            driver.quit();
        }
    }
}