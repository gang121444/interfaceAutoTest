package httpClientTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/*使用httpclient发送请求、接收响应：
 * 	1、创建httpclient对象；
 * 	2、创建请求方法的实例，并指定请求url。如需要发送get或post请求，创建HttpGet、HttpPost对象；
 * 	3、如需要发送请求参数，可调用HttpGet、HttpPost共同的setParams（HetpParams params）方法来添加请求参数。对于HttpPost而言，
 * 		还可调用setEntity(HttpEntity entity)方法来设置请求参数；
 * 	4、调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse；
 * 	5、调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头。
 * 		调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容；
 * 	6、释放连接（无论方法是否执行成功都必须释放连接）；
 */

public class HttpClientTest {
	@Test
		public void HClientTest() throws ClientProtocolException, IOException{
			String result;
			// 使用get方法，设置url
			HttpGet hGet = new HttpGet("http://www.baidu.com");
			// defaultHttpClient已过时
			HttpClient hClient = HttpClientBuilder.create().build();
			HttpResponse hResponse =hClient.execute(hGet);
			result = EntityUtils.toString(hResponse.getEntity(),"utf-8");
			System.out.println(result);
			//关闭
			((CloseableHttpClient)hClient).close();
		}
}
