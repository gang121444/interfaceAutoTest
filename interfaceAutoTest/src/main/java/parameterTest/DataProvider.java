package parameterTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider = "providerNumbers")
	public void dataProvider(String userName, int age) {
		System.out.println("userName:" + userName + ", age:" + age);
	}

	@org.testng.annotations.DataProvider(name = "providerNumbers")
	public Object[][] providerData() {
		return new Object[][] { { "zhansna", 10 }, { "lisi", 25 }, { "luxiaofeng", 35 } };
	}

	@Test(dataProvider = "methodDataTest")
	public void dataProvider111(String name, int age) {
		System.out.println("方法111执行	name:" + name + ", age:" + age);
	}
	@Test(dataProvider = "methodDataTest")
	public void dataProvider222(String name, int age) {
		System.out.println("方法222执行    name:" + name + ", age:" + age);
	}

	@org.testng.annotations.DataProvider(name = "methodDataTest")
	public Object[][] providerData1(Method method) {
		if(method.getName().equals("dataProvider111")){
			return new Object[][]{{"wangruif",29},{"xhuhuan",32}};
		}else if(method.getName().equals("dataProvider222")){
			return new Object[][]{{"guangyao",30},{"liuchang",27}};
		}
		return new Object[][] {};
	}
}
