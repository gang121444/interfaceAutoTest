package MultThreed;

import org.testng.annotations.Test;

public class MulteThreadOnAnnotation {
	@Test(invocationCount = 10, threadPoolSize = 5)
	public void multeThreadTest() {
		System.out.print("线程运行。。。");
		System.out.printf("Id：%s%n", Thread.currentThread().getId());
	}
}
