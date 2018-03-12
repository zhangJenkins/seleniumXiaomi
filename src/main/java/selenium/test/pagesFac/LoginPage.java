package selenium.test.pagesFac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.test.util.CommonPage;

public class LoginPage extends CommonPage {

	public int TimeoutValue = 30;
	public LoginPage(WebDriver driver) { 
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}
	
	
	@FindBy(id="username")
	 public static WebElement  username;
	
	@FindBy(id="pwd")
	 public static WebElement  pwd;
	
	@FindBy(id="login-button")
	 public static WebElement  loginButton;
	
	

	
	@FindBy(id="serverListTable_tbody")
	public  WebElement serverListTableTbody;
	
	
	public  void login(String user, String passwd) {
		username.clear();
		username.sendKeys(user);
		pwd.clear();
		pwd.sendKeys(passwd);
		
		loginButton.click();
		CommonPage.sleep(5);
	}
	
}
