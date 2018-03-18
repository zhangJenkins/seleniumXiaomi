package selenium.test.util;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesUtil {
	WebDriver driver;
	public FramesUtil(WebDriver driver) {
		this.driver = driver;
	}
	public void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	
	public void switchToFrame(String frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with name " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	
	public void switchToFrame(WebElement frameElement) {
		try {
				driver.switchTo().frame(frameElement);
				System.out.println("Navigated to frame with element "+ frameElement);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with element " + frameElement + e.getStackTrace());
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with element " + frameElement + e.getStackTrace());
		}
	}
	
	public void switchToFrame(String ParentFrame, String ChildFrame) {
		try {
			driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			System.out.println("Navigated to innerframe with id " + ChildFrame
					+ "which is present on frame with id" + ParentFrame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + ParentFrame
					+ " or " + ChildFrame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to innerframe with id "
					+ ChildFrame + "which is present on frame with id"
					+ ParentFrame + e.getStackTrace());
		}
	}
	
	public void switchtoDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Navigated back to webpage from frame");
		} catch (Exception e) {
			System.out
					.println("unable to navigate back to main webpage from frame"
							+ e.getStackTrace());
		}
	}
}
