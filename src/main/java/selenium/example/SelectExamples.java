package selenium.example;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectExamples {
	
	WebDriver driver;
	
	@Test(priority=1)
	public void test_ToSelectByVisibleText() {
		WebElement element = driver.findElement(By.name("Basic_Mobiles"));
		//Selecting Nokia from the dropdown using text
		select_Option_In_DropDown_ByVisibleText(element, "Nokia");
		//Verifying if selected value is displaying or not
		Assert.assertEquals("Nokia", get_SelectedOption(element), "Selected Value not displaying");
	}
	
	@Test(priority=3)
	public void test_ToSelectByIndexValue() {
		driver.navigate().refresh();
		WebElement element = driver.findElement(By.name("Costly_Mobiles"));
		//Selecting iphone from the dropdown using index value
		select_Option_In_DropDown_ByIndexVal(element, 1);
		//Verifying if selected value is displaying or not
		Assert.assertEquals("iPhone", get_SelectedOption(element), "Selected Value not displaying");
	}
	
	@Test(priority=3)
	public void test_ToSelectByValue() {
		driver.navigate().refresh();
		WebElement element = driver.findElement(By.name("China_Mobiles"));
		//Selecting iphone from the dropdown using index value
		select_Option_In_DropDown_ByValue(element, "xiomi");
		//Verifying if selected value is displaying or not
		Assert.assertEquals("Xiomi", get_SelectedOption(element), "Selected Value not displaying");
	}
	
	@Test(priority=4)
	public void test_ToCheckValueInDropdown() {
		driver.navigate().refresh();
		WebElement element = driver.findElement(By.name("Mobiles"));
		//Get all the values in dropdown
		List<WebElement> valuesInDropdown = getElementsByTagName(element, "option");
		//Pass the values that you want to check in the dropdown
		String[] checkValues= {"iPhone", "Nokia", "Samsung"};
		Assert.assertTrue(verify_Values_In_Dropdown(valuesInDropdown, checkValues), "Values are not matching with the dropdown list");
	}
	
	public static List<WebElement> getElementsByTagName(WebElement element, String optionName)
    {
       List<WebElement> listOfElements = element.findElements(By.tagName(optionName));
       if(listOfElements.size()!=0)
          return listOfElements;
       else
    	   return null;
    }
	
	public String get_SelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement selectedElement = select.getFirstSelectedOption();
		String selectedOption = selectedElement.getText();
		return selectedOption;
	}
	
	 public static void select_Option_In_DropDown_ByVisibleText(
	            WebElement element, String sVisibleTextOptionToSelect) {
	        try {
	            Select select = new Select(element);
	            select.selectByVisibleText(sVisibleTextOptionToSelect);
	           
	        } catch (NoSuchElementException e) {
	            System.out.println("Option value not find in dropdown");
	        
	        }
	    }
	 
	 public static void select_Option_In_DropDown_ByValue(WebElement element, String value) {
		 try {
	            Select select = new Select(element);
	            select.selectByValue(value);

	        } catch (NoSuchElementException e) {
	            System.out.println("Value not find in dropdown");
	          }
	    }
	 

	 public static void select_Option_In_DropDown_ByIndexVal(WebElement element, int indexVal) {
	        try {
	            Select select = new Select(element);
	            select.selectByIndex(indexVal);
	        } catch (NoSuchElementException e) {
	            System.out.println("Option value not find in dropdown");
	        }
	    }
	 
	 
	 public static boolean verify_Values_In_Dropdown(List<WebElement> listOfElements, String[] strValues) {
			boolean bValue=false;
			List<String> list = new ArrayList<String>();
			for (String strValue : strValues) {
				boolean bflag = false;
				for (WebElement element : listOfElements) {
					String elementValue = element.getText();
					if (strValue.equals(elementValue)) {
						bflag= true;
					}
				}
				if (!bflag)
					list.add(strValue);
			}
			if (list.size() > 0) {
				for(String strList : list) {
					System.out.println("Value not present in dropdown: "+strList);
				}
				//Assign false if any of the value not found in dropdown
				bValue = false;
			} else {
				//Assign true if all values found in dropdown
				System.out.println("All value(s) found in dropdown");
				bValue=true;
			}
			return bValue;
		}
	 
}
