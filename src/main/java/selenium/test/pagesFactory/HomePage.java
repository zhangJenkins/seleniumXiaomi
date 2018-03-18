package selenium.test.pagesFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage  {
	
	public int TimeoutValue = 30;
	public HomePage(WebDriver driver) { 
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}
	

}
