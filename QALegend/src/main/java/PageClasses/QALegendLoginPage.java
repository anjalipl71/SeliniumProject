package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QALegendLoginPage {
	WebDriver driver;
    @FindBy(id="email")
	WebElement usernamefield;
	@FindBy(id="password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signinbutton;
public QALegendLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}

public QALegendLoginPage loginToQaLegentPage(String username,String password) {
	usernamefield.sendKeys(username);
	passwordfield.sendKeys(password);
	signinbutton.click();
	return this;
    }
}
