package selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import selenium.test.util.CommonUtil;

public class JSClickExample {
	WebDriver driver;

	@Test
	public void testClickJS() throws Exception {
		driver = CommonUtil.open_Browser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to("http://www.amazon.com/");
		WebElement searchTextBox=driver.findElement(By.id("twotabsearchtextbox"));
		searchTextBox.sendKeys("Mobiles");
		WebElement goButton = driver.findElement(By.cssSelector("input[value=Go]"));
		safeJavaScriptClick(goButton);
	}
	
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
