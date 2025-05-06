package PageClasses;

import java.awt.print.Pageable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendMyProfilePage {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Leave']")
	WebElement Userleave;
	@FindBy(xpath = "//a[@title='Apply leave']")
	public WebElement userApplyLeave;
	@FindBy(xpath = "//span[@id='select2-chosen-3']") 
	public WebElement leaveTypeField;
	@FindBy(xpath = "(//div[@class='select2-result-label'])[2]")
	WebElement selectLeaveType;
	@FindBy(id = "duration_hours")
	WebElement selectDuration;
	@FindBy(xpath = "//input[@name='hour_date']") 
	WebElement clickDateField;	
	@FindBy(xpath = "//td[@class='today day']")
	WebElement selectTodayDate;
	@FindBy(id = "reason") 
	WebElement leaveReasonField;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement submitLeave;
	@FindBy(xpath = "//table//tbody//tr")
	WebElement leaveTableRows;
	@FindBy(xpath = "//a[@class='edit'][1]")
	WebElement clickonEdit;
	@FindBy(xpath = "//td[text()='Sick, I have an appointment with the doctor.']")
	WebElement reasonTextFind;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchfield;
	@FindBy(xpath = "//a[@title='Application details'][1]")
	WebElement clickOnEditButton;
	@FindBy(xpath = "//button[@data-status='approved']")
	WebElement clickOnApproveButton;
	@FindBy(xpath = "//th[@class='w15p sorting']")
	WebElement statusSortClick;
	@FindBy(xpath = "//th[@class='w15p sorting_asc']")
	WebElement secondClickforSort;
	@FindBy(xpath = "//div[@class='modal-body']//span[@class='label label-success' and text()='Approved']")
	WebElement statusApprovalCheck;
	@FindBy(xpath = "//div[@class='modal-content']")
	  public WebElement addProjectModal;
	
	public QALegendMyProfilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLeaveOption() {
		PageUtilities.clickonanelement(Userleave);
	}
	public void clickOnApplyLeave() {
		PageUtilities.clickonanelement(userApplyLeave);
	}
	public void createLeave(String reasonforLeave) throws InterruptedException {
		PageUtilities.clickonanelement(leaveTypeField);
		PageUtilities.clickonanelement(selectLeaveType);
		PageUtilities.clickonanelement(selectDuration);
		Thread.sleep(1000);
	    PageUtilities.clickonanelement(clickDateField);
		PageUtilities.clickonanelement(selectTodayDate);
		PageUtilities.enterText(leaveReasonField,reasonforLeave);
		PageUtilities.clickonanelement(submitLeave);
	}
	
	public boolean checkleaveapplied() throws InterruptedException {
		PageUtilities.clickonanelement(Userleave);
		Thread.sleep(1000);
		PageUtilities.clickonanelement(statusSortClick);
		Thread.sleep(2000);
		PageUtilities.clickonanelement(secondClickforSort);
		Thread.sleep(5000);
		PageUtilities.clickonanelement(clickonEdit);
		Thread.sleep(1000);
		return(reasonTextFind.isDisplayed());	
	}
	
	public void approveAppliedLeave(String searchStatus) throws InterruptedException {
		PageUtilities.enterText(searchfield, searchStatus);
		PageUtilities.clickonanelement(clickOnEditButton);
		Thread.sleep(1000);
		PageUtilities.clickonanelement(clickOnApproveButton);
	}
	
	public boolean checkApprovedStatus() throws InterruptedException {
		PageUtilities.clickonanelement(Userleave);
		Thread.sleep(1000);
		PageUtilities.clickonanelement(statusSortClick);
		Thread.sleep(1000);
		PageUtilities.clickonanelement(clickOnEditButton);
		Thread.sleep(1000);
		return(statusApprovalCheck.isDisplayed());
	}

}
