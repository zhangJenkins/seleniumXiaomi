package selenium.test.pageEle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.test.util.CommonPage;

public class LoginPage extends CommonPage {

	static By  usernameBy = By.id("username");
	static By  pwdBy = By.id("pwd");
	static By  loginButtonBy = By.id("login-button");
	
	
	
	@FindBy(id="serverListTable_tbody")
	public  WebElement serverListTableTbody;
	
	
	public static void loginBy(String user, String passwd) {
		driver.findElement(usernameBy).clear();
		driver.findElement(usernameBy).sendKeys(user);
		driver.findElement(pwdBy).clear();
		driver.findElement(pwdBy).sendKeys(passwd);
		
		driver.findElement(loginButtonBy).click();
		CommonPage.sleep(5);
	}
	
	
}
