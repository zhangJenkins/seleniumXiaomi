package selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAttributes {
	public WebDriver driver;
	private By bySearchButton = By.name("btnK");
							
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	}

	@Test
	public void getAttribute_ButtonName() {
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Name of the button is:- " +googleSearchBtn.getAttribute("name"));
	}

	@Test
	public void getAttribute_Id() {
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Id of the button is:- "+ googleSearchBtn.getAttribute("id"));
	}

	@Test
	public void getAttribute_class() {

		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Class of the button is:- "+ googleSearchBtn.getAttribute("class"));

	}

	@Test
	public void getAttribute_InvalidAttribute() {

		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		//Will return null value as the 'status' attribute doesn't exists
		System.out.println("Invalid Attribute status of the button is:- "+ googleSearchBtn.getAttribute("status"));
	}
	
	@Test
	public void getAttribute_ButtonLabel() {

		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Label of the button is:- "+ googleSearchBtn.getAttribute("aria-label"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
