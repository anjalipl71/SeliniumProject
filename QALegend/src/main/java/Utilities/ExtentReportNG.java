package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	public static ExtentReports extent;

    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir") + "\\test-output\\report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Report"); // report name
        reporter.config().setDocumentTitle("Test Results");       // doc title

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.attachReporter(reporter);                          
        extent.setSystemInfo("tester", "Anjali");                

        return extent;
	}

}
