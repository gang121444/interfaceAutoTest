package httpClientTest;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForGet<cookies, cookie> {
	private String localUri;
	private ResourceBundle bundle;
	private CookieStore store;

	@BeforeTest
	public void beforeTest() {
		// ResourceBundle为专门读取配置的工具类，后缀为properties,读取的时候无需后缀名;
		// application文件放置于main/resources目录下
		bundle = ResourceBundle.getBundle("application", Locale.CHINA);
		localUri = bundle.getString("localhost.uri");
	}

	/*
	 *  访问get请求获取返回的cookies
	 */
	@Test
	public void testGetCookies() throws ClientProtocolException, IOException {
		String result;
		// 从配置文件中提取并拼接uri
		String uri = bundle.getString("getCookie.uri");
		String pathUri = this.localUri + uri;

		// 读取返回的cookie信息并设置
		store = new BasicCookieStore();
		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();

		// 执行请求
		HttpGet get = new HttpGet(pathUri);
		CloseableHttpResponse response = client.execute(get);

		// 打印返回值
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println("get请求1返回信息为：" + result);

		// 获取cookies信息
		List<Cookie> cookies = store.getCookies();
		if (cookies != null) {
			System.out.print("访问接口成功,cookies值为：");
			for (int i = 0; i < cookies.size(); i++) {
				System.out.println(cookies.get(i).getName() + " : " + cookies.get(i).getValue());
			}
		}
	}

	/*	
	 * 携带cookies访问get请求
	 */
	@Test(dependsOnMethods = { "testGetCookies" })
	public void testGetWithCookies() throws ClientProtocolException, IOException {
		// 读取配置文件并拼接
		String uri = bundle.getString("get.with.cookie.uri");
		String getUri = this.localUri + uri;

		// 携带前一get请求的cookie，执行get请求
		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
		HttpGet get = new HttpGet(getUri);
		CloseableHttpResponse response = client.execute(get);

		// 获取状态码
		int status = response.getStatusLine().getStatusCode();
		System.out.println("状态码为：" + status);
		if (status == 200) {
			String result = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println("get2请求返回信息为：" + result);
		} else {
			System.out.println("访问/get/with/cookie接口失败");
		}
		// 关闭连接
		((CloseableHttpClient) client).close();
	}
}