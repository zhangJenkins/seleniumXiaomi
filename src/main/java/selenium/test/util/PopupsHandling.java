package selenium.test.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PopupsHandling {
	WebDriver driver;
	
	public PopupsHandling(WebDriver driver) {
		this.driver = driver ;
	}
	public String getTextConfirmBox() throws InterruptedException
	{
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		return alert.getText();
	}
	
	
	public void acceptPromptBox() throws InterruptedException
	{	
		Alert alert=driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("Helllo");
		alert.accept();
		System.out.println(alert.getText());
	}
	
	
	public void dismissConfirmBox() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@onclick='confirmFunction()']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
	}
}
