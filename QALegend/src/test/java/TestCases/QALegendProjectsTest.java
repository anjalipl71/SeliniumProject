package TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegendAddProjectPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLoginPage;
import Utilities.FakerUtility;

public class QALegendProjectsTest extends BaseClass {
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;	
	QALegendAddProjectPage addProject;

	Properties projectProp;
	FileInputStream projectfis;
	
	@BeforeMethod
	@Parameters({"browsername"})
	public void initiliazation(String browsername) throws Exception {
		driver=browseInitialization("Chrome");	
		driver.get("https://qalegend.com/crm/index.php/signin");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		loginPage=new QALegendLoginPage(driver);
		homePage=new QALegendHomePage(driver);
		addProject= new QALegendAddProjectPage(driver);
		String projectcreationpath = System.getProperty("user.dir")+"//src//test//resources//TestData//projectcreationdetails.properties";
		projectProp=new Properties();
		projectfis=new FileInputStream(projectcreationpath);
		projectProp.load(projectfis);
		
		}
	@Test
	public void addNewProjects() throws InterruptedException {
	   loginPage.loginToQaLegentPage(projectProp.getProperty("username"), projectProp.getProperty("password"));
	   homePage.clickOnProjectOption();
	   homePage.allProjectOptionClick();
	   addProject.addProjectButtonClick();
	   Thread.sleep(1000);
	   String baseTitle = projectProp.getProperty("title");
	   String title=baseTitle+FakerUtility.randomnumberGenerator();
	   addProject.createNewProjects(title);
	   Thread.sleep(1000);
	   Thread.sleep(5000);
	   addProject.searchProject(title);
	   Assert.assertEquals(addProject.cellvalueselect(), true);
	   
	}
	
	@Test
	public void addNewProjectsEdit() throws InterruptedException {
		   loginPage.loginToQaLegentPage(projectProp.getProperty("username"), projectProp.getProperty("password"));
		   homePage.clickOnProjectOption();
		   homePage.allProjectOptionClick();
		   addProject.addProjectButtonClick();
		   Thread.sleep(1000);String baseTitle = projectProp.getProperty("title");
		   String title=baseTitle+FakerUtility.randomnumberGenerator();
		   addProject.createNewProjects(title);
		   Thread.sleep(5000);
		   addProject.searchProject(title);
		   Thread.sleep(5000);
		   addProject.clickOnEditButton();
		   Thread.sleep(5000);
		   addProject.EditProject(projectProp.getProperty("description"));
		   Thread.sleep(5000);
		   addProject.clickOnEditButton();
		   Thread.sleep(5000);
		   Assert.assertEquals(addProject.checkEditedData(), true);
	}
	
	@Test
	public void projectStatusChangeandDelete() throws InterruptedException {
		   loginPage.loginToQaLegentPage(projectProp.getProperty("username"), projectProp.getProperty("password"));
		   homePage.clickOnProjectOption();
		   homePage.allProjectOptionClick();
		   Thread.sleep(5000);
		   addProject.statusCompleteProjectsDelete();
		   Thread.sleep(5000);
		   addProject.deleteCompletedProject();
		   Thread.sleep(5000);
		   Assert.assertEquals(addProject.checkDeleteTextMessage(), true);
		   
	}

}
