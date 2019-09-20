package parameterTest;

import org.testng.annotations.Test;

public class parameterOnXml {
	@Test
	@org.testng.annotations.Parameters({"userName","age"})	
	public void parameter1(String userName,int age) {
		System.out.println("name:" + userName + ", " + "age:" + age);
	}
	
	@Test(dependsOnMethods={"parameter1"})
	public void parameter2(){
		System.out.println("parameter2 执行完毕");
	}
}
