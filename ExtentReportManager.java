package Assignment;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extentReports;

    public static ExtentReports getExtentReports() {
        if (extentReports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);
        }
        return extentReports;
    }
}