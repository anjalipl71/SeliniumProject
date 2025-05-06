package TestCases;

import java.io.FileInputStream;
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
import Utilities.FakerUtility;
import Utilities.RetryAnalyser;
import Utilities.waitUtility;

public class QALegendAddTicketsTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendAddTicketPage addTicketspage;
	Properties tickectprop;
	FileInputStream ticketfis;
	
	@BeforeMethod()
	@Parameters({"browsername"})
	public void initiliazation(String browsername) throws Exception {
	driver=browseInitialization("Chrome");	
	driver.get("https://qalegend.com/crm/index.php/signin");
	driver.manage().window().maximize();
	loginPage=new QALegendLoginPage(driver);
	homePage=new QALegendHomePage(driver);
	addTicketspage=new QALegendAddTicketPage(driver);
	
	String ticketcreationpath = System.getProperty("user.dir")+"//src//test//resources//TestData//ticketcreationdetails.properties";
	tickectprop=new Properties();
	ticketfis = new FileInputStream(ticketcreationpath);
	tickectprop.load(ticketfis);
	}
	
	@Test(priority = 1,groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void addNewTicket() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.clickonNewTicketsButton);
		addTicketspage.clickOnAddTickets();
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		waitUtility.waitForVisibilityOfElement(driver, addTicketspage.titleField);
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		addTicketspage.waitForInvisibilityOfTicketModal();
		addTicketspage.ticketsSearch(title);
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.ticketsDeletearrowicon);
		addTicketspage.ticketsDeleting();//findMessageSentorNot
		//waitUtility.waitForVisibilityOfElement(driver, addTicketspage.findMessageSentorNot);
		Thread.sleep(5000);
		Assert.assertEquals(addTicketspage.confirmDeleteTextMessage(), true);
	}
	
	
	@Test(priority = 2,groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void assigningTicket() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.clickonNewTicketsButton);
		addTicketspage.clickOnAddTickets();
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		waitUtility.waitForVisibilityOfElement(driver, addTicketspage.titleField);
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		addTicketspage.waitForInvisibilityOfTicketModal();
		addTicketspage.ticketsSearch(title);
		addTicketspage.clickonsearchedTicketTitle();
		//Thread.sleep(5000);
		//waitUtility.waitForVisibilityOfElement(driver, addTicketspage.clickonsearchedTicket);
		Assert.assertEquals(addTicketspage.assignefind(), true);
	}
	
	@Test(priority = 3,groups= {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void markasClosedTicket() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.clickonNewTicketsButton);
		addTicketspage.clickOnAddTickets();
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		waitUtility.waitForVisibilityOfElement(driver, addTicketspage.titleField);
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		addTicketspage.waitForInvisibilityOfTicketModal();
		addTicketspage.ticketsSearch(title);
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.clickonsearchedTicket);
		addTicketspage.ticketMarkedAsClosed();
		//Thread.sleep(2000);
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.clickonNewTicketsButton);
		Assert.assertEquals(addTicketspage.checkClosedStatus(), true);
	}
	
	@Test(priority = 4,groups= {"regression","sanity"},retryAnalyzer = RetryAnalyser.class)
	public void ticketsMessagePost() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.clickonNewTicketsButton);
		addTicketspage.clickOnAddTickets();
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		waitUtility.waitForVisibilityOfElement(driver, addTicketspage.titleField);
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		addTicketspage.waitForInvisibilityOfTicketModal();
		addTicketspage.ticketsSearch(title);
		addTicketspage.createMessageinTicket(tickectprop.getProperty("message"));
		Thread.sleep(5000);
		Assert.assertEquals(addTicketspage.checkMessageSentOrNot(), true);
	}
	

}
