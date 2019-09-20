package groupsTest;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class groupsOnClass3 {
	@Test
	public void groupsOnClass1() {
		System.out.println("groupsOnClass3中的stu333运行了");
	}

	@Test
	public void groupsOnClass2() {
		System.out.println("groupsOnClass3中的stu444运行了");
	}
}
