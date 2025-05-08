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
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.ticketsDeleteicon);
		addTicketspage.ticketsDeleting();//findMessageSentorNot
		waitUtility.waitForVisibilityOfElement(driver, addTicketspage.confirmDeleteMessage);
		Assert.assertTrue(addTicketspage.confirmDeleteTextMessage());
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
		waitUtility.waitForVisibilityOfElement(driver, addTicketspage.findAssigneduser);
		Assert.assertTrue(addTicketspage.assignefind());
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
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.checkStatusClosed);
		Assert.assertTrue(addTicketspage.checkClosedStatus());
	}
	
	@Test(priority = 4,groups= {"regression","sanity"},retryAnalyzer = RetryAnalyser.class)
	public void postticketsMessage() throws InterruptedException {
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
		waitUtility.waitForClickingonAnElement(driver, addTicketspage.findMessageSentorNot);
		Assert.assertTrue(addTicketspage.checkMessageSentOrNot());
	}
	

}
