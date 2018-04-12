package selenium.crawler;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.test.util.CommonUtil;

public class CsdnCrawler implements Runnable{

	 @Override  
    public void run() {  
		 openCsdnLink();
	 }  
	
	@Test
	public void openCsdnLink() {
		String threadName = Thread.currentThread().getName();
		WebDriver driver = CommonUtil.open_Browser("PhantomJS");		 
		driver.navigate().to("https://blog.csdn.net/xiaoguanyusb");				
		List<WebElement> elementList = new ArrayList<>();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul[2]/li[2]/ul[2]"));
		elementList = element.findElements(By.tagName("li"));
		
		List<String> urlList = new ArrayList<>();
		String temp = null;
		for (WebElement webElement : elementList) {
			temp = webElement.findElement(By.tagName("a")).getAttribute("href");
			urlList.add(temp);
			
		}
//		for (int j = 0; j < 20; j++) {
			for (int i = 0; i < urlList.size(); i++) {
				driver.get(urlList.get(i));
				System.out.println(threadName + "\t urlList:_"+"_"+ i + "\t:" + urlList.get(i));
			}	
//		}
		
		
		driver.quit();
	}
	
}
