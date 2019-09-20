package groupsTest;

import org.testng.annotations.Test;

@Test(groups = "stu")
// 类分组
public class groupsOnClass1 {
	@Test
	public void groupsOnClass1() {
		System.out.println("groupsOnClass1中的stu1111运行");
	}

	@Test
	public void groupsOnClass2() {
		System.out.println("groupsOnClass1中的stu2222运行");
	}
}
