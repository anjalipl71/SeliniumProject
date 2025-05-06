package TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegendAddEventPage;
import PageClasses.QALegendLoginPage;
import Utilities.FakerUtility;
import Utilities.RetryAnalyser;

public class QALegendAddEventTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendAddEventPage addEventPage;
	Properties prop;
	FileInputStream fis;
	
	
	
	@BeforeMethod
	@Parameters({"browsername"})
	public void initiliazation(String browsername) throws Exception {
		driver=browseInitialization("Chrome");	
		driver.get("https://qalegend.com/crm/index.php/signin");
		driver.manage().window().maximize();
		loginPage=new QALegendLoginPage(driver);
		addEventPage=new QALegendAddEventPage(driver);
		String basePath = System.getProperty("user.dir")+"//src//test//resources//TestData//addeventuserdetails.properties";
		prop=new Properties();
		fis=new FileInputStream(basePath);
		prop.load(fis);
		
	}
	
	@Test(groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void addEventUsingQuickAdd() throws InterruptedException {
		loginPage.loginToQaLegentPage(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		addEventPage.addEventUsingQuickAddButton();
		Thread.sleep(5000);
		String baseTitle = prop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		addEventPage.newAddEvent(title, prop.getProperty("description"),driver);
		
	}

}
