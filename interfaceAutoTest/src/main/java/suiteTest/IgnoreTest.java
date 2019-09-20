package suiteTest;

import org.testng.annotations.Test;

public class IgnoreTest {
	@Test
	public void ignore1() {
		System.out.println("ignore1 执行");
	}

	@Test(enabled = false)
	// 忽略测试
	public void ignore2() {
		System.out.println("ignore2执行");
	}

	@Test(enabled = true)
	//不添加enable，默认为true
	public void ignore3() {
		System.out.println("ignore3 执行");
	}
}
