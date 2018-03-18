package selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.test.util.CommonUtil;

public class PageScroll {
	WebDriver driver;
	String URL = "https://www.linkedin.com/";

	@BeforeClass
	public void setUp() {
		driver = CommonUtil.open_Browser("chrome");
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void scrollingToBottomofAPage() {
		driver.navigate().to(URL);
		 ((JavascriptExecutor) driver)
         .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@Test(priority=2)
	public void scrollingToElementofAPage() {
		driver.navigate().to(URL+"directory/companies?trk=hb_ft_companies_dir");
		WebElement element = driver.findElement(By.linkText("Import/Export"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	@Test(priority=3)
	public void scrollingByCoordinatesofAPage() {
		driver.navigate().to(URL+"job/?trk=hb_ft_jobs");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	 public static void scrollToBottom(WebDriver driver) {
	        ((JavascriptExecutor) driver)
	                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }
	 
	 public static void scrollTo(WebDriver driver, WebElement element) {
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", element);
	    }
}
