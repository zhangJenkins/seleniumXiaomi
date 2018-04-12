package script.xiaomi;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.test.App;
import selenium.test.pagesFactory.HomePage;
import selenium.test.pagesFactory.LoginPage;
import selenium.test.util.CommonUtil;



public class test {

	@Test
	public void testFun(){
		CommonUtil commonUtil = new CommonUtil();
		
		try {			
			WebDriver driver = CommonUtil.open_Browser("chrome");
			commonUtil.enter_URL(App.URL);
			CommonUtil.sleep(2);
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login("*******","*******");
			
			
			commonUtil.close_Browser();	
			
		} catch (Exception e) {
			commonUtil.close_Browser();
		}	
	}
	
	@Test
	public void testFun001(){
		Assert.assertTrue(false);
		}
}
