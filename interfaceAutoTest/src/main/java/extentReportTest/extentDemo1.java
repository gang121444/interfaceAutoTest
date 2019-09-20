package extentReportTest;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class extentDemo1 {
	@Test
	public void test1() {
		assertEquals(1, 1);
		System.out.println("boolean: true");
	}

	@Test
	public void test2() {
		assertEquals(1, 2);
		System.out.println("boolean: false");
	}

	@Test
	public void test3() {
		assertEquals(true, false);
		System.out.println("true or false");
	}

	@Test
	public void logDemo() {
		Reporter.log("this is our own print log");
		throw new RuntimeException("主动抛出的运行异常");
		
	}
}
