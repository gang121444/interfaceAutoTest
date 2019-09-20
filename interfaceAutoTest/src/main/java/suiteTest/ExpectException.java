package suiteTest;

import org.testng.annotations.Test;

public class ExpectException {
	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	// 添加预期异常
	public void unExpectException() {
		System.out.println("预期异常未发生");
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void expectException() {
		System.out.println("预期异常已被捕获");
		throw new ArithmeticException("空指针异常");
	}

}
