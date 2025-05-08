package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Tickets']")
	public WebElement QALegendHomePageTicketOption;
	@FindBy(xpath = "//span[text()='Team members']")
	WebElement QaLegendHomePageTeamMemberOptions;
	@FindBy(xpath = "//a[@href='https://qalegend.com/crm/index.php/projects']")
	WebElement clickOnProjects;
	@FindBy(xpath = "//span[text()='All Projects']")
	WebElement clickonallProjectsOption;
	@FindBy(xpath = "//span[@class='topbar-user-name']")
	public WebElement clickonUserProfileName;
	@FindBy(xpath = "//a[@href='https://qalegend.com/crm/index.php/team_members/view/1/general']")
	public WebElement clickonMyProfile;
	
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public QALegendHomePage clickonTeamMemberbutton() {
		PageUtilities.clickonanelement(QaLegendHomePageTeamMemberOptions);
		return this;
	}
	
	public QALegendHomePage clickonTicketsMenu() {
		PageUtilities.clickonanelement(QALegendHomePageTicketOption);
		return this;
	}
	
	public QALegendHomePage clickOnProjectOption() {
		PageUtilities.clickonanelement(clickOnProjects);
		return this;
	}
	
	public QALegendHomePage ClickallProjectOption() {
		PageUtilities.clickonanelement(clickonallProjectsOption);
		return this;
	}
	
	public QALegendHomePage ClickonUsermyProfileName() {
		PageUtilities.clickonanelement(clickonUserProfileName);
		return this;
	}
	
	public QALegendHomePage myProfileClick() {
		PageUtilities.clickonanelement(clickonMyProfile);
		return this;
	}

}
