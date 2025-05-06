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
import Utilities.RetryAnalyser;
import Utilities.waitUtility;

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
	@Test(priority = 1,groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void addNewProjects() throws InterruptedException {
	   loginPage.loginToQaLegentPage(projectProp.getProperty("username"), projectProp.getProperty("password"));
	   homePage.clickOnProjectOption();
	   homePage.allProjectOptionClick();
	   addProject.addProjectButtonClick();
	   String baseTitle = projectProp.getProperty("title");
	   String title=baseTitle+FakerUtility.randomnumberGenerator();
	   waitUtility.waitForVisibilityOfElement(driver, addProject.addTitle);
	   addProject.createNewProjects(title);
	   addProject.waitForInvisibilityOfProjectModal();
	   addProject.searchProject(title);
	   Assert.assertEquals(addProject.cellvalueselect(), true);
	   
	}
	
	@Test(priority = 2,groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void addNewProjectsEdit() throws InterruptedException {
		   loginPage.loginToQaLegentPage(projectProp.getProperty("username"), projectProp.getProperty("password"));
		   homePage.clickOnProjectOption();
		   homePage.allProjectOptionClick();
		   addProject.addProjectButtonClick();
		   String baseTitle = projectProp.getProperty("title");
		   String title=baseTitle+FakerUtility.randomnumberGenerator();
		   waitUtility.waitForVisibilityOfElement(driver, addProject.addTitle);
		   addProject.createNewProjects(title);
		   addProject.waitForInvisibilityOfProjectModal();
		   addProject.searchProject(title);
		   waitUtility.waitForVisibilityOfElement(driver, addProject.editProjectButton);
		   addProject.clickOnEditButton();
		   waitUtility.waitForVisibilityOfElement(driver, addProject.addTitle);
		   addProject.EditProject(projectProp.getProperty("description"));
		   waitUtility.waitForVisibilityOfElement(driver, addProject.editProjectButton);
		   addProject.clickOnEditButton();
//		   Thread.sleep(5000);
//		   Assert.assertEquals(addProject.checkEditedData(), true);
	}
	
	@Test(priority = 3,groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void projectStatusChangeandDelete() throws InterruptedException {
		   loginPage.loginToQaLegentPage(projectProp.getProperty("username"), projectProp.getProperty("password"));
		   homePage.clickOnProjectOption();
		   homePage.allProjectOptionClick();
		   waitUtility.waitForVisibilityOfElement(driver, addProject.QALegendProjectPageEditButton);
		   addProject.statusCompleteProjectsDelete();
		   waitUtility.waitForVisibilityOfElement(driver, addProject.selectStatusComplete);
		   addProject.deleteCompletedProject();
		   Thread.sleep(5000);
		   Assert.assertEquals(addProject.checkDeleteTextMessage(), true);
		   
	}

}
