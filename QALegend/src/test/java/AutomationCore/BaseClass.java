package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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
		else if(browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else 
		{
			throw new Exception("Invalid Exception");
		}
		return driver;
	}
}
