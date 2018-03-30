package testng.testngxml.multipleClasses;

import org.testng.annotations.Test;

public class demoOne {
	@Test
	public void firstTestCase()
	{
		System.out.println("im in first test case from demoOne Class");
	}
	
	@Test
	public void secondTestCase()
	{
		System.out.println("im in second test case from demoOne Class");
	}
}
