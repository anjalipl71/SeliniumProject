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

public class QALegendAddTicketsTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendAddTicketPage addTicketspage;
	Properties tickectprop;
	FileInputStream ticketfis;
	
	@BeforeMethod
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
	
	@Test
	public void addNewTicket() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		Thread.sleep(5000);
		addTicketspage.clickOnAddTickets();
		Thread.sleep(5000);
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		Thread.sleep(5000);
		addTicketspage.ticketsSearch(title);
		Thread.sleep(5000);
		addTicketspage.ticketsDeleting();
		Thread.sleep(1000);
		Assert.assertEquals(addTicketspage.confirmDeleteTextMessage(), true);
	}
	
	
	@Test
	public void assigningTicket() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		Thread.sleep(5000);
		addTicketspage.clickOnAddTickets();
		Thread.sleep(5000);
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		Thread.sleep(5000);
		addTicketspage.ticketsSearch(title);
		addTicketspage.clickonsearchedTicketTitle();
		Thread.sleep(5000);
		Assert.assertEquals(addTicketspage.assignefind(), true);
	}
	
	@Test
	public void markasClosedTicket() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		Thread.sleep(5000);
		addTicketspage.clickOnAddTickets();
		Thread.sleep(5000);
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		Thread.sleep(5000);
		addTicketspage.ticketsSearch(title);
		Thread.sleep(1000);
		addTicketspage.ticketMarkedAsClosed();
		Thread.sleep(2000);
		Assert.assertEquals(addTicketspage.checkClosedStatus(), true);
	}
	
	@Test
	public void ticketsMessagePost() throws InterruptedException {
		loginPage.loginToQaLegentPage(tickectprop.getProperty("username"), tickectprop.getProperty("password"));
		homePage.clickonTicketsMenu();
		Thread.sleep(5000);
		addTicketspage.clickOnAddTickets();
		Thread.sleep(5000);
		String baseTitle = tickectprop.getProperty("title");
		String title=baseTitle+FakerUtility.randomnumberGenerator();
		addTicketspage.createNewTickets(title, tickectprop.getProperty("description"));
		Thread.sleep(5000);
		addTicketspage.ticketsSearch(title);
		addTicketspage.createMessageinTicket(tickectprop.getProperty("message"));
		Thread.sleep(5000);
		Assert.assertEquals(addTicketspage.checkMessageSentOrNot(), true);
	}
	

}
