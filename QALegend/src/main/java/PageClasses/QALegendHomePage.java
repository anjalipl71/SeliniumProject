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
	WebElement allProjectsclick;
	@FindBy(xpath = "//span[@class='topbar-user-name']")
	public WebElement userMyProfileClick;
	@FindBy(xpath = "//a[@href='https://qalegend.com/crm/index.php/team_members/view/1/general']")
	WebElement clickonMyProfile;
	
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickonTeamMemberbutton() {
		PageUtilities.clickonanelement(QaLegendHomePageTeamMemberOptions);
	}
	
	public void clickonTicketsMenu() {
		PageUtilities.clickonanelement(QALegendHomePageTicketOption);
	}
	
	public void clickOnProjectOption() {
		PageUtilities.clickonanelement(clickOnProjects);
	}
	
	public void allProjectOptionClick() {
		PageUtilities.clickonanelement(allProjectsclick);
	}
	
	public void usermyProfileClick() {
		PageUtilities.clickonanelement(userMyProfileClick);
	}
	
	public void myProfileClick() {
		PageUtilities.clickonanelement(clickonMyProfile);
	}

}
