package selenium.testest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeTest
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() {
		// Your test code here
	}

}