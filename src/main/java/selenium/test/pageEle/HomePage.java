package selenium.test.pageEle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.test.util.CommonPage;


public class HomePage extends CommonPage {
	
	public int TimeoutValue = 30;
	public HomePage(WebDriver driver) { 
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}
	
	@FindBy(xpath="//*[@id=\"J_userInfo\"]/a[1]")
	 public static WebElement loginElemnt;

	public static void goToLoginPage() {
		driver.findElement(By.xpath("//*[@id=\"J_userInfo\"]/a[1]")).click();
	}
}
