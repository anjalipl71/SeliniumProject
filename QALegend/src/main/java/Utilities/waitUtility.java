package Utilities;

import java.lang.invoke.ConstantBootstraps;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constant;

public class waitUtility {
	 public static void waitForClickingonAnElement(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	
	public static void waitForTexttoBePresentinElement(WebDriver driver, WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
    }

    public static void waitForElementToBeSelected(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public static void waitForVisibilityAndClickability(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public static void waitForInvisibilityOfAnElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
        wait.until(ExpectedConditions.invisibilityOf(element));
        
    } 

	}


