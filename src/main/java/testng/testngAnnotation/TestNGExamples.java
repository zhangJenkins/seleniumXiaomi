package testng.testngAnnotation;

import org.testng.annotations.Test;

public class TestNGExamples {
	
	/**
	 * Timeout Test in TestNG
	 */
	@Test
	public void sampleTestCase(){
			System.out.println("Im ready to execute");
		}
	@Test(timeOut=1000) // specify time in milliseconds
	public void executetimeOut() throws InterruptedException{
		Thread.sleep(3000);
     // Thread.sleep(500);
	}
	
	
	/**
	 * TestNG Test Case Priority
	 */
	@Test
	public void registerAccount()
	{
		System.out.println("First register your account");
	}
	@Test(priority=2)
	public void sendEmail()
	{
		System.out.println("Send email after login");
	}
	@Test(priority=1)
	public void login()
	{
		System.out.println("Login to the account after registration");
	}
}
