package groupsTest;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class groupsOnClass2 {
	@Test
	public void groupsOnClass1() {
		System.out.println("groupsOnClass2中的stu111运行了");
	}

	@Test
	public void groupsOnClass2() {
		System.out.println("groupsOnClass2中的stu222运行了");
	}
}
