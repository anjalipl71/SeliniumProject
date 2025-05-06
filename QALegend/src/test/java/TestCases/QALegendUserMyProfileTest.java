package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegendAddTicketPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendMyProfilePage;
import PageClasses.QALegendTeamMemberPage;
import Utilities.RetryAnalyser;
import Utilities.waitUtility;

public class QALegendUserMyProfileTest extends BaseClass {
	WebDriver driver;
	QALegendLoginPage loginpage;
	QALegendHomePage homePage;
	QALegendMyProfilePage myProfilePage;
	Properties propProfile;
	FileInputStream fisProfile;
	
	
	@BeforeMethod
	@Parameters({"browsername"})
	public void initiliazation(String browsername) throws Exception {
	driver=browseInitialization(browsername);
	driver.get("https://qalegend.com/crm/index.php/signin");
	driver.manage().window().maximize();
	loginpage=new QALegendLoginPage(driver);
	homePage=new QALegendHomePage(driver);
	myProfilePage=new QALegendMyProfilePage(driver);
	String basePath = System.getProperty("user.dir")+"//src//test//resources//TestData//userprofiledetails.properties";
	propProfile=new Properties();
	fisProfile=new FileInputStream(basePath);
    propProfile.load(fisProfile);
	}
	
    @Test(priority = 1,groups= {"sanity"},retryAnalyzer = RetryAnalyser.class)
	public void userMyProfileOption() throws InterruptedException, IOException {
    	
		loginpage.loginToQaLegentPage(propProfile.getProperty("username"), propProfile.getProperty("password")); 
		waitUtility.waitForClickingonAnElement(driver, homePage.userMyProfileClick); // example
		homePage.usermyProfileClick();
		waitUtility.waitForClickingonAnElement(driver, homePage.userMyProfileClick);
		homePage.myProfileClick();
		myProfilePage.clickOnLeaveOption();
		waitUtility.waitForClickingonAnElement(driver, myProfilePage.userApplyLeave);
		myProfilePage.clickOnApplyLeave();
		waitUtility.waitForClickingonAnElement(driver, myProfilePage.leaveTypeField);
		myProfilePage.createLeave(propProfile.getProperty("reason"));
		Thread.sleep(10000);
		Assert.assertEquals(myProfilePage.checkleaveapplied(), true);
    }
    
    @Test(priority = 2,groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void approveLeave() throws InterruptedException {
		loginpage.loginToQaLegentPage(propProfile.getProperty("username"), propProfile.getProperty("password"));
		homePage.usermyProfileClick();
		waitUtility.waitForClickingonAnElement(driver, homePage.userMyProfileClick);
		homePage.myProfileClick();
		myProfilePage.clickOnLeaveOption();
		waitUtility.waitForClickingonAnElement(driver, myProfilePage.userApplyLeave);
		myProfilePage.approveAppliedLeave(propProfile.getProperty("searchvalue"));
		Thread.sleep(5000);
		Assert.assertEquals(myProfilePage.checkApprovedStatus(), true);
	}
}


