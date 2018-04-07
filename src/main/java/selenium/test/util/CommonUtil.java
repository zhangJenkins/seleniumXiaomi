package selenium.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {

	static String driverPath = "D:\\workspace\\eclipse\\testest\\src\\driver\\";

	protected static WebDriver driver;
	 WebDriverWait wait;
	 private final int TIMEOUT = 10;
	 public CommonUtil() {}
	    
	protected CommonUtil(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT) , this);
	    }
	    
	protected CommonUtil(WebDriver driver, final String title) {
	        this.driver = driver;
	        
	        //如果不进行判断，
	        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
	        try{
	            boolean flag = wait.until(new ExpectedCondition<Boolean>(){
	                @Override
	                public Boolean apply(WebDriver arg0) {
	                    // TODO Auto-generated method stub
	                    String acttitle = arg0.getTitle();
	                    return acttitle.equals(title);                    
	                }});
	        }catch(TimeoutException te) {
	            throw new IllegalStateException("当前不是预期页面，当前页面title是：" + driver.getTitle());
	        }
	}   
	        
	        
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		CommonUtil.driver = driver;
	}

	public static  WebDriver open_Browser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",driverPath + "chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver","D:/Jars/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}else if (browserName.equalsIgnoreCase("PhantomJS")) {
				// 设置必要参数
				DesiredCapabilities dcaps = new DesiredCapabilities();
				// ssl证书支持
				dcaps.setCapability("acceptSslCerts", true);
				// 截屏支持
				dcaps.setCapability("takesScreenshot", true);
				// css搜索支持
				dcaps.setCapability("cssSelectorsEnabled", true);
				// js支持
				dcaps.setJavascriptEnabled(true);
				// 驱动支持
				dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, driverPath +"phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
				// 创建无界面浏览器对象
				PhantomJSDriver driver = new PhantomJSDriver(dcaps);

				return driver;
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		
		return driver;
	}
	
	
	public  WebDriver open_Browser_selenium3(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
				System.out.println("launching firefox browser"); 
				System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","D:\\workspace\\eclipse\\testest\\src\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.out.println("launching Microsoft Edge browser");
				System.setProperty("webdriver.edge.driver", driverPath+"MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		
		return driver;
	}
	
	
	

	public void enter_URL(String URL) {
		driver.navigate().to(URL);
	}

	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public void enter_Text(String locatorType, String value, String text) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Button(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}
	
	public void close_Browser() {
		driver.quit();
	}
	
	
	
	public static void sleep(int second) {
		
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteAllCookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	public void deleteCookieNamedExample(String cookieName)
	{
		driver.manage().deleteCookieNamed(cookieName);
	}
}
