package script.xiaomi;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.test.App;
import selenium.test.pagesFactory.LoginPage;
import selenium.test.util.CommonUtil;



public class test {

	@Test
	public void testFun(){
		CommonUtil commonUtil = new CommonUtil();
		WebDriver driver = null;
		try {			
			driver = CommonUtil.open_Browser("PhantomJS");
//			commonUtil.enter_URL(App.URL);
			driver.navigate().to(App.URL);
			CommonUtil.sleep(2);
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login("*******","*******");
			
			String title = driver.getTitle();
			System.out.println("title:" + title);
			driver.quit();
			
		} catch (Exception e) {
			driver.quit();
		}	
	}
	
	@Test
	public void testFun001(){
		Assert.assertTrue(false);
		}
}
