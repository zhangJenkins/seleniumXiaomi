package selenium.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsElement {

	WebDriver driver;
	
	public void isElementPresent(By locator,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
	}
	
	public void isElementClickable(By locator,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator)); 
	}
	
	public void isElementVisible(By locator,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
	}
	
	
	public void islinkElementsVisible(WebElement linkElements,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
	}
	
	public void isElementInVisible(By locator,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)); 
	}
	
	public void isElementEnabled(WebElement element) {
		element.isEnabled();
	}
	
	public void isElementDisplayed(WebElement element) {
		element.isDisplayed();
	}
	
	public void waitForInvisibilityOfElementWithText(By locator,String strText,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, strText));
	}
	

}
