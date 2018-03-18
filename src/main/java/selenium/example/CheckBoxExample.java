package selenium.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import selenium.test.util.CommonUtil;

public class CheckBoxExample {
	WebDriver driver;

	@Test
	public void testMultipleCheckBox() throws Exception {
		driver = CommonUtil.open_Browser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to("App URL");

		WebElement element1 = driver.findElement(By.cssSelector("input[value=itunes]"));
		WebElement element2 = driver.findElement(By.cssSelector("input[value=lastfm]"));
		WebElement element3 = driver.findElement(By.cssSelector("input[value=spotify]"));
		WebElement[] elements = { element1, element2, element3 };
		safeSelectCheckBoxes(10, elements);
	}

	public void safeSelectCheckBoxes(int waitTime, WebElement... elements) throws Exception {
		WebElement checkElement = null;
		try {
			if (elements.length > 0) {
				for (WebElement currentElement : elements) {
					checkElement = currentElement;
					WebDriverWait wait = new WebDriverWait(driver, waitTime);
					wait.until(ExpectedConditions.elementToBeClickable(currentElement));

					WebElement checkBox = currentElement;
					if (checkBox.isSelected())
						System.out.println("CheckBox " + currentElement
								+ " is already selected");
					else
						checkBox.click();
				}
			} else {
				System.out
						.println("Expected atleast one element as argument to safeSelectCheckboxes function");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element - " + checkElement
					+ " is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + checkElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out
					.println("Unable to select checkbox " + e.getStackTrace());
		}
	}
	
	public void Select_The_Checkbox(WebElement element) {
		try {
            if (element.isSelected()) {
               System.out.println("Checkbox: " + element + "is already selected");
            } else {
            	// Select the checkbox
                element.click();
            }
        } catch (Exception e) {
        	System.out.println("Unable to select the checkbox: " + element);
        }
		
	}
	
	
	public void DeSelect_The_Checkbox(WebElement element) {
		try {
            if (element.isSelected()) {
            	//De-select the checkbox
                element.click();
            } else {
            	System.out.println("Checkbox: "+element+"is already deselected");
            }
        } catch (Exception e) {
        	System.out.println("Unable to deselect checkbox: "+element);
        }
    }		
	
	
	public void Select_The_CheckBox_from_List(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			   System.out.println("Option value "+option.getText());
			        if (valueToSelect.equals(option.getText())) {
			            option.click();
			            break;
			        }
			    }
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
