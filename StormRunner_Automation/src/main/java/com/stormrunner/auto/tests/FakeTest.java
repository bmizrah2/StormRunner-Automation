package il.co.jb.amazon.auto.tests;

import java.io.File;

import org.testng.annotations.Test;

import il.co.jb.amazon.auto.infra.utils.AssertUtils;

public class FakeTest extends AbstractTest {

	
	@Test
	public void fakeTest1() {
		
		AssertUtils.assertEquals(3, 3, "ints should be equal");
		
		report.log("This is after the assert...");
		
	}
	
	
	@Test
	public void fakeTest2() {
	
		File f = new File("C:\\Users\\jbt\\Desktop\\tt1.txt");
		
		AssertUtils.assertTrue(f.exists(), "File should exist");
		
		report.log("This is after the assert...");
		
	}
}
