package selenium.test.pageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.util.CommonUtil;

public class LoginPage extends CommonUtil {

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
		CommonUtil.sleep(5);
	}
	
	
}
