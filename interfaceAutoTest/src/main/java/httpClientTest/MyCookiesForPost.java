package httpClientTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForPost {
	// localhost
	private String url;
	// 读取配置文件
	private ResourceBundle bundle;
	// 存储cookies信息
	private CookieStore store;

	@BeforeTest
	public void BeforeTest() {
		/*
		 * 读取localhost
		 */
		bundle = ResourceBundle.getBundle("application", Locale.CHINA);
		url = bundle.getString("localhost.uri");
	}

	@Test
	public void getCookies() throws ClientProtocolException, IOException {
		String result;
		// 拼接get请求uri
		String Uri = bundle.getString("getCookie.uri");
		String getUri = this.url + Uri;

		// 获取并设置cookies
		this.store = new BasicCookieStore();
		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();

		// 执行get请求
		HttpGet get = new HttpGet(getUri);
		CloseableHttpResponse response = client.execute(get);

		// 获取返回值
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println("返回值为：" + result);

		// 读取cookie信息
		List<Cookie> cookies = store.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.size(); i++) {
				System.out.println("获取到的cookie信息为：" + cookies.get(i).getName() + ":" + cookies.get(i).getValue());
			}
		}
	}

	@Test(dependsOnMethods = { "getCookies" })
	public void sendPostWithCookies() throws ClientProtocolException, IOException {
		String result;
		// 拼接post请求的uri
		String uri = bundle.getString("post.with.cookie.uri");
		String postUri = this.url + uri;

		// 声明post请求，将get请求中获取到的cookies设置到post请求内
		HttpPost post = new HttpPost(postUri);
		CloseableHttpClient pClient = HttpClients.custom().setDefaultCookieStore(this.store).build();

		// 准备参数，json格式
		JSONObject param = new JSONObject();
		param.put("name", "spmcs");
		param.put("age", "3");

		// 将准备好的参数信息添加到post请求内
		StringEntity entity = new StringEntity(param.toString(), "utf-8");
		post.setEntity(entity);

		// 设置或修改header，添加为addheader
		post.setHeader("Content-Type", "application/json");

		// 执行post请求并获取响应结果
		CloseableHttpResponse response = pClient.execute(post);

		// 判断响应结果是否符合预期
		int status = response.getStatusLine().getStatusCode();
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(result);
		if (status == 200) {
			// 将响应结果转化为json对象
			JSONObject resultJson = new JSONObject(result);
			
			// 获取到结果值
			String code = (String) resultJson.get("proCode");
			String name = (String) resultJson.get("Fname");
			
			// 添加断言，若参数一致则程序继续，否则中断并抛出异常
			assertEquals(code, "360001");
			assertEquals(name, "simulate post request");
			
			System.out.println("proCode:" + code);
			System.out.println("Fname:" + name);
		} else {
			System.out.println("post请求访问失败！");
		}
	}
}
