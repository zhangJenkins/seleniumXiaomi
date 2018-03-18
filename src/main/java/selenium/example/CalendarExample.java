package selenium.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.test.util.CommonUtil;

public class CalendarExample {

	private String URL = "http://demos.telerik.com/aspnet-ajax/ajax/examples/loadingpanel/explicitshowhide/defaultcs.aspx";
	private String kendoURL = "http://jqueryui.com/resources/demos/datepicker/other-months.html";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = CommonUtil.open_Browser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	
	@Test
	public void jQueryCalendarMultipleMonths() {
		driver.navigate().to("http://jqueryui.com/resources/demos/datepicker/other-months.html");
		WebElement calElement=driver.findElement(By.id("datepicker"));
		calElement.click();
		selectDatefromMultiDate("30");
	}
	
	public void selectDatefromMultiDate(String date) {
		By calendarXpath=By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"+date+"']");
		//By calendarXpath=By.xpath("table//td/a[text()='"+date+"']");
		driver.findElement(calendarXpath).click();
	}
	
	
	@Test
	public void kendoCalendarExample() {
		driver.navigate().to(kendoURL);
		WebElement calIcon = driver.findElement(By.cssSelector(".k-icon.k-i-calendar"));
		calIcon.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("datetimepicker_dateview")));
		System.out.println("Calendar Found");
		selectKendoDate("10");
	}

	public void selectKendoDate(String date) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("k-content")));
		WebElement table = driver.findElement(By.className("k-content"));

		System.out.println("Kendo Calendar");
		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(date)) {
					driver.findElement(By.linkText(date)).click();
				}
			}
		}
	}

	String jQueryURL = null;
	By frameLocator;
	private By tagText;
	
	@Test
	public void jQueryCalendarExample() {
		driver.navigate().to(jQueryURL);		
		WebElement frameElement = driver.findElement(frameLocator);
		driver.switchTo().frame(frameElement);
		wait.until(ExpectedConditions.presenceOfElementLocated(tagText));
		driver.findElement(tagText).click();
		selectJQueryDate("21");
	}

	public void selectJQueryDate(String date) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));
		WebElement table = driver.findElement(By.className("ui-datepicker-calendar"));
		System.out.println("JQuery Calendar Dates");

		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(date)) {
					driver.findElement(By.linkText(date)).click();
				}
			}
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
