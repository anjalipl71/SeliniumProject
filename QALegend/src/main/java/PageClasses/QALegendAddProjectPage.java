package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.waitUtility;

public class QALegendAddProjectPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add project']")
	WebElement addProjectButton;
	@FindBy(xpath = "//input[@name='title']")
	public WebElement addTitle;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveProjectsClick;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBoxField;
	@FindBy(xpath = "//a[@title='Edit project']")
	public WebElement editProjectButton;
	@FindBy(xpath = "//div[@class='select2-container select2 validate-hidden']")
	public WebElement selectClientValuedropdown;
	@FindBy(xpath = "//div[contains(@id,'select2-result-label') and normalize-space()='Amazon']")
	WebElement selectClientValue;
	@FindBy(id = "description")
	WebElement projectDescription;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveChanges;
	@FindBy(xpath = "//a[@title='Edit project']")
	public WebElement QALegendProjectPageEditButton;
	@FindBy(xpath = "//div[@class='select2-container select2']")
	WebElement editStatus;
	@FindBy(xpath = "//div[contains(@id,'select2-result-label') and normalize-space()='Completed']")
	WebElement selectCompleteStatus;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveCompleteStatus;
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	WebElement projectStatusChange;
	@FindBy(xpath = "//li[@data-value='completed']")
	public WebElement selectStatusComplete;
	@FindBy(xpath = "//a[@title='Delete project'][1]")
	WebElement selectDeleteButton;
	@FindBy(id = "confirmDeleteButton")
	WebElement confirmDeleteButton;
	@FindBy(xpath = "//tr[@class='odd'or @class='even']")
	WebElement projectcellvalue;
	@FindBy(xpath = "//textarea[text()='Changing Client Value']")
	public WebElement checkDescriptionTextArea;
	@FindBy(xpath = "//div[text()='The record has been deleted.']")
	public WebElement checkDeleteMessage;
	@FindBy(xpath = "//div[@class='modal-content'][1]")
	public WebElement addProjectModal;

	

	public QALegendAddProjectPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	public QALegendAddProjectPage addProjectButtonClick() {
		PageUtilities.clickonanelement(addProjectButton);
		return this;
	}
	
	public QALegendAddProjectPage createNewProjects(String title) {
		PageUtilities.enterText(addTitle, title);
		PageUtilities.clickonanelement(saveProjectsClick);
		return this;
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
	
	public QALegendAddProjectPage statusCompleteProjectsDelete() throws InterruptedException {
		PageUtilities.clickonanelement(QALegendProjectPageEditButton);
		waitUtility.waitForVisibilityOfElement(driver, editStatus);
		PageUtilities.clickonanelement(editStatus);
		PageUtilities.clickonanelement(selectCompleteStatus);
		PageUtilities.clickonanelement(saveCompleteStatus);
		waitUtility.waitForVisibilityOfElement(driver, projectStatusChange);
		waitForInvisibilityOfProjectModal();
		PageUtilities.clickonanelement(projectStatusChange);
		return this;
		
	}
	
	public void deleteCompletedProject() throws InterruptedException {
		PageUtilities.clickonanelement(selectStatusComplete);
		waitUtility.waitForElementToBeClickable(driver, selectDeleteButton);
		//Thread.sleep(5000);
		PageUtilities.clickonanelement(selectDeleteButton);
		waitUtility.waitForVisibilityOfElement(driver, confirmDeleteButton);
		PageUtilities.clickonanelement(confirmDeleteButton);
	}
	
	public boolean checkDeleteTextMessage() {
		return checkDeleteMessage.isDisplayed();
	}
	
	 public void waitForInvisibilityOfProjectModal() {
		 waitUtility.waitForInvisibilityOfAnElement(driver, addProjectModal);
	 }

}
