package AutomationCore;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import Utilities.ScreenshotUtility;

public class BaseClass {
	public WebDriver driver;
	public WebDriver browseInitialization(String browsername) throws Exception
	{
		if(browsername.equalsIgnoreCase("Chrome")){
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Firefox")) {
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else 
		{
			throw new Exception("Invalid Exception");
		}
		return driver;
	
	}
	@AfterMethod
	public void afterMethod(ITestResult itResult) throws IOException {
		if(itResult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility sc=new ScreenshotUtility();
			sc.captureFailureScreenshot(driver, itResult.getName());
		}
		if(driver!=null) {
			driver.quit();
		}
	}
}
