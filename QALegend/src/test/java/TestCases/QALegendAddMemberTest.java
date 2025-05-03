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
import Constants.Constant;
import PageClasses.QALegendTeamMemberPage;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import PageClasses.QALegendAddTicketPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLoginPage;


public class QALegendAddMemberTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginpage;
	QALegendHomePage homePage;
	QALegendAddTicketPage ticketPage;
	QALegendTeamMemberPage teamMemberPage;
	Properties prop;
	FileInputStream fis;
	
	@BeforeMethod
	@Parameters({"browsername"})
	public void initiliazation(String browsername) throws Exception {
	driver=browseInitialization(browsername);
	driver.get("https://qalegend.com/crm/index.php/signin");
	driver.manage().window().maximize();
	loginpage=new QALegendLoginPage(driver);
	ticketPage=new QALegendAddTicketPage(driver);
	homePage=new QALegendHomePage(driver);
    teamMemberPage=new QALegendTeamMemberPage(driver);
	String basePath = System.getProperty("user.dir")+"//src//test//resources//TestData//userdetails.properties";
	prop=new Properties();
	fis=new FileInputStream(basePath);
    prop.load(fis);
	}
	
	

	@Test

	public void addTeamMember() throws InterruptedException, IOException {
		
		loginpage.loginToQaLegentPage(prop.getProperty("username"), prop.getProperty("password")); 
		homePage.clickonTeamMemberbutton();
		teamMemberPage.addTeamMemberbuttonclick();
		Thread.sleep(1000);
		String firstName= ExcelUtility.readStringData(1, 0, "TeamMembers", Constant.EXCELFILEPATH)+FakerUtility.randomnumberGenerator();
	    String lastName=ExcelUtility.readStringData(1, 1, "TeamMembers", Constant.EXCELFILEPATH)+FakerUtility.randomnumberGenerator();
	    String teammemberrole = ExcelUtility.readStringData(1, 2, "TeamMembers", Constant.EXCELFILEPATH);
	    String salary = ExcelUtility.readStringData(1, 3, "TeamMembers", Constant.EXCELFILEPATH);
	    String emailid=ExcelUtility.readStringData(1, 4, "TeamMembers", Constant.EXCELFILEPATH);	    
	    String teammemberpassword=ExcelUtility.readStringData(1, 5, "TeamMembers", Constant.EXCELFILEPATH);
	    teamMemberPage.addnewteammember(firstName,lastName,teammemberrole,salary,emailid,teammemberpassword);
	    Thread.sleep(10000);
		teamMemberPage.searchbuttonclick(emailid);
		Thread.sleep(5000);
		Assert.assertEquals(teamMemberPage.cellvalueFinder(), true);
		
		
	}
	

}
