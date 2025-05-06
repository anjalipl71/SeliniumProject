package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendAddEventPage {
	WebDriver driver;
	@FindBy(id = "quick-add-icon")
	WebElement openuickAdd;
	@FindBy(xpath = "//a[@title='Add event']")
	WebElement addEventClick;
	@FindBy(xpath = "//input[@name='title']")
	WebElement addEventTitleField;
	@FindBy(id = "description")
	WebElement addEventDescriptionField;
	@FindBy(xpath = "//input[@name='start_date']")
	WebElement addEventStartDate;
	@FindBy(xpath = "//td[contains(@class, 'today') and contains(@class, 'day')]")
	WebElement addEventStartDateSelect;
	@FindBy(xpath = "//input[@name='start_time']")
	WebElement addEventStartTime;
	@FindBy(xpath = "//input[@name='end_date']")
	WebElement addEventEndDate;
	@FindBy(xpath = "//td[contains(@class, 'today') and contains(@class, 'day')]")
	WebElement addEventEndDateSelect;
	@FindBy(xpath = "//input[@name='end_time']")
	WebElement addEventEndTime;
	@FindBy(id = "share_with_all")
	WebElement shareWithCheckbox;
	@FindBy(id="event_recurring")
	WebElement repeatCheckbox;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButtonClick;
	@FindBy(xpath = "//div[text()='The record has been deleted.']")
	WebElement confirmDeleteMessage;
	
	public QALegendAddEventPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public QALegendAddEventPage addEventUsingQuickAddButton() {
		PageUtilities.clickonanelement(openuickAdd);
		PageUtilities.clickonanelement(addEventClick);
		return this;
	}
	
	public QALegendAddEventPage newAddEvent(String title,String description,WebDriver driver) throws InterruptedException {
		PageUtilities.enterText(addEventTitleField, title);
		PageUtilities.enterText(addEventDescriptionField, description);
		PageUtilities.clickonanelement(addEventStartDate);
		PageUtilities.clickonanelement(addEventStartDateSelect);
		PageUtilities.clickonanelement(addEventStartTime);
		PageUtilities.clickonanelement(addEventEndDate);
		PageUtilities.clickonanelement(addEventEndDateSelect);
		PageUtilities.clickonanelement(addEventEndTime);
		PageUtilities.clickonanelement(shareWithCheckbox);
		Thread.sleep(5000);
		PageUtilities.scrollToElement(driver, repeatCheckbox);
		PageUtilities.clickonanelement(repeatCheckbox);
		PageUtilities.clickonanelement(saveButtonClick);
		return this;
	}	

	
	  public boolean confirmDeleteTextMessage() {
			return confirmDeleteMessage.isDisplayed();
		}
	

}
