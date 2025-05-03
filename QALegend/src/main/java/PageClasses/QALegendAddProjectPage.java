package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendAddProjectPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add project']")
	WebElement addProjectButton;
	@FindBy(xpath = "//input[@name='title']")
	WebElement addTitle;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveProjectsClick;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBoxField;
	@FindBy(xpath = "//a[@title='Edit project']")
	WebElement editProjectButton;
	@FindBy(xpath = "//div[@class='select2-container select2 validate-hidden']")
	WebElement selectClientValuedropdown;
	@FindBy(xpath = "//div[contains(@id,'select2-result-label') and normalize-space()='Amazon']")
	WebElement selectClientValue;
	@FindBy(id = "description")
	WebElement projectDescription;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveChanges;
	@FindBy(xpath = "//a[@title='Edit project']")
	WebElement selectEditProject;
	@FindBy(xpath = "//div[@class='select2-container select2']")
	WebElement editStatus;
	@FindBy(xpath = "//div[contains(@id,'select2-result-label') and normalize-space()='Completed']")
	WebElement selectCompleteStatus;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveCompleteStatus;
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	WebElement projectStatusChange;
	@FindBy(xpath = "//li[@data-value='completed']")
	WebElement selectStatusComplete;
	@FindBy(xpath = "//a[@title='Delete project'][1]")
	WebElement selectDeleteButton;
	@FindBy(id = "confirmDeleteButton")
	WebElement confirmDeleteButton;
	@FindBy(xpath = "//tr[@class='odd'or @class='even']")
	WebElement projectcellvalue;
	@FindBy(xpath = "//textarea[text()='Changing Client Value']")
	WebElement checkDescriptionTextArea;
	@FindBy(xpath = "//div[text()='The record has been deleted.']")
	WebElement checkDeleteMessage;
	

	

	public QALegendAddProjectPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	public void addProjectButtonClick() {
		PageUtilities.clickonanelement(addProjectButton);
	}
	
	public void createNewProjects(String title) {
		PageUtilities.enterText(addTitle, title);
		PageUtilities.clickonanelement(saveProjectsClick);
	}
	
	public void searchProject(String searchValue) {
		PageUtilities.enterText(searchBoxField, searchValue);
	}
	
	public boolean cellvalueselect() {
		return(projectcellvalue.isDisplayed());
	}
	
	public void clickOnEditButton() {
		PageUtilities.clickonanelement(editProjectButton);
	}
	
	public void EditProject(String description) throws InterruptedException {
		PageUtilities.clickonanelement(selectClientValuedropdown);
		PageUtilities.clickonanelement(selectClientValue);
		PageUtilities.enterText(projectDescription, description);
		PageUtilities.clickonanelement(saveChanges);	
	}
	
	public boolean checkEditedData() {
		return checkDescriptionTextArea.isDisplayed();
	}
	
	public void statusCompleteProjectsDelete() throws InterruptedException {
		PageUtilities.clickonanelement(selectEditProject);
		Thread.sleep(2000);
		PageUtilities.clickonanelement(editStatus);
		PageUtilities.clickonanelement(selectCompleteStatus);
		PageUtilities.clickonanelement(saveCompleteStatus);
		Thread.sleep(2000);
		PageUtilities.clickonanelement(projectStatusChange);
		Thread.sleep(2000);
	}
	
	public void deleteCompletedProject() throws InterruptedException {
		PageUtilities.clickonanelement(selectStatusComplete);
		Thread.sleep(3000);
		PageUtilities.clickonanelement(selectDeleteButton);
		Thread.sleep(3000);
		PageUtilities.clickonanelement(confirmDeleteButton);
	}
	
	public boolean checkDeleteTextMessage() {
		return checkDeleteMessage.isDisplayed();
	}

}
