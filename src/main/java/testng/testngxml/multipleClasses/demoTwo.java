package testng.testngxml.multipleClasses;

import org.testng.annotations.Test;

public class demoTwo {
	@Test
	public void firstTestCase()
	{
		System.out.println("im in first test case from demoTwo Class");
	}
	
	@Test
	public void secondTestCase()
	{
		System.out.println("im in second test case from demoTwo Class");
	}
}
