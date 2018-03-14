package script.xiaomi;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import selenium.test.App;
import selenium.test.pagesFactory.HomePage;
import selenium.test.pagesFactory.LoginPage;
import selenium.test.util.CommonPage;



public class test {

	@Test
	public void testFun(){
		CommonPage commonUtil = new CommonPage();
		
		try {			
			WebDriver driver = commonUtil.open_Browser("chrome");
			commonUtil.enter_URL(App.URL);
			CommonPage.sleep(2);
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login("*******","*******");
			
			
			commonUtil.close_Browser();	
			
		} catch (Exception e) {
			commonUtil.close_Browser();
		}	
	}
}
