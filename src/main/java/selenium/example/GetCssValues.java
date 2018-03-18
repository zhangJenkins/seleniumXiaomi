package selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetCssValues {
	public WebDriver driver;
	private By bySearchButton = By.name("btnK");
								
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	}

	@Test(priority=1)
	public void getCssValue_ButtonColor()  {
		WebElement googleSearchBtn = driver.findElement(bySearchButton); 
		System.out.println("Color of a button before mouse hover: "	+ googleSearchBtn.getCssValue("color"));
		Actions action = new Actions(driver);
		action.moveToElement(googleSearchBtn).perform();
		System.out.println("Color of a button after mouse hover : "	+ googleSearchBtn.getCssValue("color"));
	}
	
	@Test(priority=2)
	public void getCssValue_ButtonFontSize() {
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Font Size of a button "	+ googleSearchBtn.getCssValue("font-size"));
	}
	
	@Test(priority=3)
	public void getCssValue_ButtonFontWeight(){
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Font Weight of a button "	+getFontWeight(googleSearchBtn) );
	}
	
	public String getFontWeight(WebElement element) {
		//Output will return as 400 for font-weight : normal, and 700 for font-weight : bold
		return element.getCssValue("font-weight");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
