package MultThreed;

import org.testng.annotations.Test;

public class TimeOutTest {

	@Test(timeOut=2000)
	public void timeOut() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println("线程超时");
	}
	@Test(timeOut=3000)
	public void timeThrough() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println("线程未超时");
	}
}

