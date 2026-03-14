package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports getReportInstance(){

        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/FlightReport.html");

        reporter.config().setReportName("Flight Booking Automation Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}