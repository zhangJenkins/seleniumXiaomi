package selenium.example;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import selenium.test.util.CommonUtil;

public class takeScreenShotExample {
	   public WebDriver driver;
       
	      @Test
	      public void openBrowser() throws Exception {
	    	  driver =  CommonUtil.open_Browser("chrome");
	    	  driver.manage().window().maximize();
	    	  driver.get("http://www.baidu.com");
	    	  try{
	                //the below statement will throw an exception as the element is not found, Catch block will get executed and takes the screenshot.
	    		  driver.findElement(By.id("testing")).sendKeys("test");
	                 
	                   //if we remove the below comment, it will not return exception and screen shot method will not get executed.
	    		  //driver.findElement(By.id("gbqfq")).sendKeys("test");
	    	  }
	    	  catch (Exception e){
	    		  System.out.println("I'm in exception");
	//calls the method to take the screenshot.
	    		  getscreenshot();
	     	  }
	      }
	      
	      public void getscreenshot() throws Exception 
	      {
	              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           //The below method will save the screen shot in d drive with name "screenshot.png"
	              FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
	      }
}
