package autoTest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void testCase1() {
		System.out.println("case1 这是测试用例1");
		// assert.assertTrue(true);
	}

	@BeforeMethod
	//注释的方法将在属于test标签内的类的所有测试方法运行之前运行
	public void beforeMethod() {
		System.out.println("before 这是测试用例执行前");
	}

	@Test
	//将类或方法标记为测试的一部分，此标记若放在类上，则该类所有公共方法都将被作为测试方法
	public void testCase2() {
		System.out.println("case2 这是测试案例2");
	}

	@AfterMethod
	//注释的方法将在属于test标签内的类的所有测试方法运行之后运行
	public void afterMethod() {
		System.out.println("after 这是测试案例执行后");
	}

	@BeforeClass
	//在调用当前类的第一个测试方法之前运行，注释方法仅运行一次
	public void beforeClass() {
		System.out.println("BeforeClass 类运行前执行");
	}

	@AfterClass
	//在调用当前类的第一个测试方法之后运行，注释方法仅运行一次
	public void afterClass() {
		System.out.println("afterClass 类运行后执行");
	}

	@BeforeSuite
	//在该套件的所有测试都运行在注释方法之前，仅运行一次
	public void beforeSuite() {
		System.out.println("BeforeSuite,套件");
	}

	@AfterSuite
	//在该套件的所有测试都运行在注释方法之后，仅运行一次
	public void afterSuite() {
		System.out.println("afterSuite,套件测试");
	}

}
