package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.waitUtility;

public class QALegendTeamMemberPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add member']")
	WebElement addTeamMemberButton;
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstnamefield;
	@FindBy(xpath = "//input[@name='last_name']") 
	WebElement lastnamefield;
	@FindBy(id="form-next")
	WebElement nextButton;
	@FindBy(id="job_title")
	WebElement jobtitleField;
	@FindBy(xpath = "//input[@name='salary']")
	WebElement salaryfield;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(id = "form-submit")
	WebElement saveTeammemberButton;
	@FindBy(xpath = "//div[@id='team_member-table_filter']//descendant::input")
	WebElement searchfield;
	@FindBy(xpath = "//tr[@class='odd'or @class='even']")
	WebElement teammembercellvalue;
	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement addMemberModal;
	
	
	public QALegendTeamMemberPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addTeamMemberbuttonclick() {
		PageUtilities.clickonanelement(addTeamMemberButton);
	}


	public void addnewteammember(String firstname,String lastname,String jobtitle,String salary,String email,String password) {
		PageUtilities.enterText(firstnamefield, firstname);
		PageUtilities.enterText(lastnamefield, lastname);
		PageUtilities.clickonanelement(nextButton);
		PageUtilities.enterText(jobtitleField, jobtitle);
		PageUtilities.enterText(salaryfield, salary);
		PageUtilities.clickonanelement(nextButton);
		PageUtilities.enterText(emailField, email);
		PageUtilities.enterText(passwordfield, password);
		PageUtilities.clickonanelement(saveTeammemberButton);
	}
	
	public void searchbuttonclick(String searchvalue) {
		PageUtilities.enterText(searchfield, searchvalue);
	}
	
	public boolean cellvalueFinder() {
		return(teammembercellvalue.isDisplayed());
	}
	
	 public void waitForInvisibilityOfAddMemberModal() {
		 waitUtility.waitForInvisibilityOfAnElement(driver, addMemberModal);
	 }
	

//		
//		
//	}

}
