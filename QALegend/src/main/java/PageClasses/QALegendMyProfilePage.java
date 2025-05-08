package PageClasses;

import java.awt.print.Pageable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.waitUtility;

public class QALegendMyProfilePage {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Leave']")
	public WebElement clickOnleaveOption;
	@FindBy(xpath = "//a[@title='Apply leave']")
	public WebElement clickOnApplyLeave;
	@FindBy(xpath = "//span[@id='select2-chosen-3']") 
	public WebElement leaveTypeField;
	@FindBy(xpath = "(//div[@class='select2-result-label'])[2]")
	WebElement clickOnLeaveType;
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
	public WebElement findReason;
	@FindBy(xpath = "//input[@type='search']")
	public WebElement searchfield;
	@FindBy(xpath = "//a[@title='Application details'][1]")
	WebElement clickOnEditButton;
	@FindBy(xpath = "//button[@data-status='approved']")
	WebElement clickOnApproveButton;
	@FindBy(xpath = "//th[@class='w15p sorting']")
	public WebElement clickOnstatusforSort;
	@FindBy(xpath = "//th[@class='w15p sorting_asc']")
	WebElement secondClickforSort;
	@FindBy(xpath = "//div[@class='modal-body']//span[@class='label label-success' and text()='Approved']")
	public WebElement checkApprovedStatus;
	@FindBy(xpath = "(//div[@class='modal-content'])[2]")
	public WebElement addMyProfileModal;
	
	public QALegendMyProfilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public QALegendMyProfilePage clickOnLeaveOption() {
		PageUtilities.clickonanelement(clickOnleaveOption);
		return this;
	}
	public QALegendMyProfilePage clickOnApplyLeave() {
		PageUtilities.clickonanelement(clickOnApplyLeave);
		return this;
	}
	public QALegendMyProfilePage createLeave(String reasonforLeave) throws InterruptedException {
		PageUtilities.clickonanelement(leaveTypeField);
		PageUtilities.clickonanelement(clickOnLeaveType);
		PageUtilities.clickonanelement(selectDuration);
	    PageUtilities.clickonanelement(clickDateField);
		PageUtilities.clickonanelement(selectTodayDate);
		PageUtilities.enterText(leaveReasonField,reasonforLeave);
		PageUtilities.clickonanelement(submitLeave);
		return this;
	}
	
	
	public QALegendMyProfilePage checkAppliedLeave() throws InterruptedException {
		waitUtility.waitForVisibilityOfElement(driver, clickOnstatusforSort);
		PageUtilities.clickonanelement(clickOnstatusforSort);
		waitUtility.waitForVisibilityOfElement(driver, secondClickforSort);
		PageUtilities.clickonanelement(secondClickforSort);
		waitUtility.waitForVisibilityOfElement(driver, clickonEdit);
		PageUtilities.clickonanelement(clickonEdit);
		return this;
		
	}
	
	public boolean checkreason() throws InterruptedException {
			return(findReason.isDisplayed());
	}
	public QALegendMyProfilePage approveAppliedLeave(String searchStatus) throws InterruptedException {
		PageUtilities.enterText(searchfield, searchStatus);
		PageUtilities.clickonanelement(clickOnEditButton);
		waitUtility.waitForVisibilityOfElement(driver, clickOnApproveButton);
		PageUtilities.clickonanelement(clickOnApproveButton);
		return this;
	}
	
	public boolean checkApprovedStatus() throws InterruptedException {
		waitUtility.waitForVisibilityOfElement(driver, clickOnstatusforSort);
		PageUtilities.clickonanelement(clickOnstatusforSort);
		waitUtility.waitForVisibilityOfElement(driver, clickOnEditButton);
		PageUtilities.clickonanelement(clickOnEditButton);
		waitUtility.waitForVisibilityOfElement(driver, checkApprovedStatus);
		return(checkApprovedStatus.isDisplayed());
	}
	
	public void waitForInvisibilityOfMyProfileModal() {
		waitUtility.waitForInvisibilityOfAnElement(driver, addMyProfileModal);
		}

}
