package suiteTest;

import org.testng.annotations.Test;

public class DependTest {
	@Test(enabled = false)
	public void normalMethod() {
		System.out.println("自定义方法1");
	}

	@Test(dependsOnMethods = { "normalMethod" })
	// 设置被依赖的方法
	public void dependOnNromal() {
		System.out.println("该方法依赖于normal方法");
	}
}
