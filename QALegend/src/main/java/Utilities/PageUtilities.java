package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public static void clickonanelement(WebElement element) {
		element.click();
	}
	public static void navigateTo(WebDriver driver, String url) {
		driver.navigate().to(url);
	}
	public static void navigateback(WebDriver driver) {
		driver.navigate().back();
	}
    public static void navigateforward(WebDriver driver) {
        driver.navigate().forward();
    }
    public static void navigaterefresh(WebDriver driver) {
        driver.navigate().refresh();
    }
	public static void mouseHover(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}	
	public static void doblelick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public static void rightClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
    public static void enterText(WebElement element,String value) {
    	element.sendKeys(value);
    }
    public static void SelectbyValue(WebElement element,String value) {
    	Select dropDown=new Select(element);
    	dropDown.selectByValue(value);
    }
    public static void selectbyIndex(WebElement element,Integer index) {
		Select dropDown =new Select(element);
		dropDown.selectByIndex(index);
	}
    public static void selectByVisibletext(WebElement element,String value) {
		Select dropDown =new Select(element);
		dropDown.selectByVisibleText(value);
	}
    public static void draganddrop(WebDriver driver,WebElement source,WebElement destination){
    	Actions action = new Actions(driver);
    	action.dragAndDrop(source, destination).build().perform();
    }
	public static void clickingusingavascript(WebDriver driver,WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public static void scrollstillelementvisible(WebDriver driver,WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void uploadFile(WebElement element, String filePath) {
	    element.sendKeys(filePath);
	}
	public static void cleartext(WebElement element) {
		element.clear();
		
	}
	public static void acceptAlert(WebDriver driver ) {
		driver.switchTo().alert().accept();
	}
	public static void dismissAlert(WebDriver driver ) {
		driver.switchTo().alert().dismiss();
	}
	public static void enterValueintoAlert(WebDriver driver,String value ) {
		driver.switchTo().alert().sendKeys(value);
	}
	public static String enterValueintoAlert(WebDriver driver ) {
		return(driver.switchTo().alert().getText());
	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
  
}
