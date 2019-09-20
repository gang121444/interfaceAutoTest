package suiteTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
	@BeforeSuite
	public void suiteConfig(){
		System.out.println("beforeSuite 单次执行");
	}
	@AfterSuite
	public void afterConfig(){
		System.out.println("afterSuite 单次执行");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("beforeTest 执行");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("afterTest 执行");
	}
}
