package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.waitUtility;

public class QALegendAddTicketPage {
	WebDriver driver;
	  @FindBy(xpath = "//a[@class='btn btn-default']")  //a[@title='Add ticket']")
	  public WebElement clickonNewTicketsButton;
	  @FindBy(xpath = "//input[@name='title']")
	  public WebElement titleField;
	  @FindBy(id="s2id_client_id")
	  WebElement selectClientdropdownClick;
	  @FindBy(xpath="//div[contains(@id,'select2-result-label') and normalize-space()='123']")
	  WebElement clickOnClientValue;
	  @FindBy(id="description")
	  WebElement descriptionField;
	  @FindBy(xpath="//button[@type='submit']")
	  WebElement clickOnSaveButton;
	  @FindBy(xpath = "//input[@type='search']")
	  public WebElement ticketsSearchField;
	  @FindBy(xpath =("//button[@class='btn btn-default dropdown-toggle  mt0 mb0'][1]"))
	  public WebElement ticketsDeleteicon;
	  @FindBy(xpath = "//a[@title='Delete'][1]")
	  WebElement clickonDelete;
	  @FindBy(xpath = "//button[@id='confirmDeleteButton']")
	  WebElement confirmDeleteButton ;
	  @FindBy(xpath = "(//tr[@role='row']//child::a)[1]")
	  public WebElement clickonsearchedTicket;
	  @FindBy(xpath = "(//button[@type='button'])[3]") 
	  WebElement clickOnActionButton;
	  @FindBy(xpath = "(//li[@role='presentation']//child::a)[3]")
	  WebElement chooseAssigntoMe;
	  @FindBy(xpath = "//span[contains(text(), 'Assigned to:')]/following-sibling::a[contains(text(), 'Megha Rajeev')]")
	  public WebElement findAssigneduser;
	  @FindBy(xpath = "(//li[@role='presentation']//child::a)[2]")
	  WebElement chooseMarkasClosed;
	  @FindBy(xpath = "//span[text()='Closed']")
	  public WebElement checkStatusClosed;
	  @FindBy(id = "description")
	  WebElement enterMessagefield;
	  @FindBy(xpath = "//div[text()='The record has been deleted.']")
	  public WebElement confirmDeleteMessage;
	  @FindBy(xpath = "//button[@type='submit']")
	  WebElement postcommentButtonClick;
	  @FindBy(xpath = "//p[text()='Ok. Will update']")
	  public WebElement findMessageSentorNot;
	  @FindBy(xpath = "//div[@class='modal-content']")
	  public WebElement addTicketModal;
	  
	  public QALegendAddTicketPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	}

	public QALegendAddTicketPage clickOnAddTickets() {
		  PageUtilities.clickonanelement(clickonNewTicketsButton);
		  return this;
	  }
	  
	  public QALegendAddTicketPage createNewTickets(String title,String desciption) {
		  PageUtilities.enterText(titleField, title);
		  PageUtilities.clickonanelement(selectClientdropdownClick);
		  PageUtilities.clickonanelement(clickOnClientValue);
		  PageUtilities.enterText(descriptionField, desciption);
		  PageUtilities.clickonanelement(clickOnSaveButton);
		  return this;
	  }
	  
	  public QALegendAddTicketPage ticketsSearch(String searchValue) {
          PageUtilities.enterText(ticketsSearchField, searchValue);
          return this;
	  }

	  
	  public QALegendAddTicketPage ticketsDeleting() throws InterruptedException {
		  PageUtilities.clickonanelement(ticketsDeleteicon);
		  PageUtilities.clickonanelement(clickonDelete);
		  waitUtility.waitForClickingonAnElement(driver, confirmDeleteButton);
		  PageUtilities.clickonanelement(confirmDeleteButton);
		  return this;
	  }
	  
	  public boolean confirmDeleteTextMessage() {
			return confirmDeleteMessage.isDisplayed();
		}
	  
	  public QALegendAddTicketPage clickonsearchedTicketTitle() {
		  PageUtilities.clickonanelement(clickonsearchedTicket);
		  PageUtilities.clickonanelement(clickOnActionButton);
		  PageUtilities.clickonanelement(chooseAssigntoMe);
		  return this;
	  }
	  
	  public boolean assignefind() {
		  return findAssigneduser.isDisplayed();

	  }
	  
	  public QALegendAddTicketPage ticketMarkedAsClosed() {
		  PageUtilities.clickonanelement(clickonsearchedTicket);
		  PageUtilities.clickonanelement(clickOnActionButton);
		  PageUtilities.clickonanelement(chooseMarkasClosed);
		  return this;
	  }
	
	 public boolean checkClosedStatus() {
		 return checkStatusClosed.isDisplayed();
	 }
	 
	 public void createMessageinTicket(String message) {
		 PageUtilities.clickonanelement(clickonsearchedTicket);
		 PageUtilities.enterText(enterMessagefield, message);
		 PageUtilities.clickonanelement(postcommentButtonClick);
	 }
	 
	 public boolean checkMessageSentOrNot() {
		 return findMessageSentorNot.isDisplayed();
	 }
	 
	 public void waitForInvisibilityOfTicketModal() {
		 waitUtility.waitForInvisibilityOfAnElement(driver, addTicketModal);
	 }
}
