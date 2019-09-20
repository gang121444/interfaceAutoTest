package httpClientTest;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForGet {
	private String localUri;
	private ResourceBundle bundle;

	@BeforeTest
	public void beforeTest() {
		// ResourceBundle为专门读取配置的工具类，后缀为properties,读取的时候无需后缀名
		bundle = ResourceBundle.getBundle("application", Locale.CHINA);
		localUri = bundle.getString("localhost.uri");
	}

	@Test
	public void testGetCookies() throws ClientProtocolException, IOException {
		String result;
		// 从配置文件中拼接uri
		String uri = bundle.getString("getCookie.uri");
		String pathUri = this.localUri + uri;
		// get方法设置访问的uri
		HttpGet get = new HttpGet(pathUri);
		// 读取返回的信息
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(get);
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(result);
		// 关闭连接
		
		((CloseableHttpClient) client).close();
	}

}