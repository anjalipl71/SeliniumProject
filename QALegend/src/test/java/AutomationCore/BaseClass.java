package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public WebDriver driver;
	public WebDriver browseInitialization(String browsername) throws Exception
	{
		if(browsername.equalsIgnoreCase("Chrome")){
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Firefox")) {
			driver = new ChromeDriver();
		}
		else 
		{
			throw new Exception("Invalid Exception");
		}
		return driver;
	}
}
