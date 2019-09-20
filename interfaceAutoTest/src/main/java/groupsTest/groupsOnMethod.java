package groupsTest;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupsOnMethod {
	@Test(groups="server")
	//方法分组
	public void groupsOnServer1(){
		System.out.println("groups on server1");
	}
	
	@Test(groups="server")
	public void groupsOnServer2(){
		System.out.println("groups on server2");
	}
	
	@Test(groups="client")
	public void groupsOnClient(){
		System.out.println("groups on client");
	}
	
	@BeforeGroups("server")
	public void beforeGroups(){
		System.out.println("beforeGroups 服务端运行111   之前");
	}
	
	@AfterGroups("server")
	public void afterGroups(){
		System.out.println("afterGroups 服务端运行111    之后");
	}
}
