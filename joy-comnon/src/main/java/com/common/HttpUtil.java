package com.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.common.URLUtil.SMS;

public class HttpUtil {
	/**
	 * 
	 *  1、 
	 */
	public static String SendURLAndParam(String url, String method, String param) {
		String res = "";
		BufferedReader reader = null;
		try {
			// 1、获取真正的url
			// url = url+"?";
//			param = URLEncoder.encode(param);// url编码  不是必须,看具体 接口需要
			URL realUrl = new URL(url + "?" + param);// 没有param url跟上？也不会出错
			// 2、获取url链接
			URLConnection conn = realUrl.openConnection();
			// 3、设置链接属性
			// Http报头分为通用报头，请求报头，响应报头和实体报头。
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("Method", method);// GET还是POST
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");// 用户代理
			// 4、建立连接，发送请求
			conn.connect();
			// 5、获取所有响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 6、遍历所有响应头字段，获取到 cooies等
			for (String key : map.keySet()) {
				System.out.println(key + "-->" + map.get(key));
			}
			// 7、定义BufferedReader 输入流来读取 URL的响应
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;// 循环读取
			while ((line = reader.readLine()) != null) {
				res += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {// 关闭流
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}
	/**
	 * 
	 *   2、
	 * @return
	 */
	static public String sendHttpURLAndData(String postData, String postUrl) {

		try {
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Length", "" + postData.length());
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(postData);
			out.flush();
			out.close();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return "";
			}
			String line, result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}
			in.close();
			return result;
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 
	 * 3、使用httpclient进行访问，需要是到 http://hc.apache.org/下载jar包
	 * 
	 * @param url
	 * @return
	 */
	static public String httpPost(String url,Map<String,String> head,String postData,Map<String,String> param) {
		String address = "";
		  CloseableHttpClient httpClient = HttpClients.createDefault(); 

		try {
			HttpPost httpPost = new HttpPost(url);
			/**   
			 *  
			 *  返回数据处理
			 *  
			 */
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
//						HttpEntity entity = response.getEntity();
//						return entity != null ? EntityUtils.toString(entity) : null;
						return "ok";
					} else {
						return  null;
//						throw new ClientProtocolException("Unexpected response status:" + status);
					}

				}
			};
			/**
			 * 
			 *  添加 head 头信息
			 */
			if (head!=null) {
				Set<String> keys = head.keySet();  
                for (Iterator<String> i = keys.iterator(); i.hasNext();) {  
                    String key = (String) i.next();  
                    httpPost.addHeader(key, head.get(key));         
                }  
			}
			/**
			 *   添加   param尾部参数
			 *  
			 */
			List<NameValuePair> list = new LinkedList<>();
			if (param!=null) {
				Set<String> keys = param.keySet();  
                for (Iterator<String> i = keys.iterator(); i.hasNext();) {  
                    String key = (String) i.next();  
                    BasicNameValuePair p = new BasicNameValuePair(key,param.get(key));
                           list.add(p);
                }  
			}
			// 使用URL实体转换工具
		    UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
		    httpPost.setEntity(entityParam);
			/**
			 * 
			 *  添加  body信息
			 */
			StringEntity se = new StringEntity(postData);
			se.setContentEncoding("HTTP.UTF_8");
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			httpPost.setEntity(se);			
			address = httpClient.execute(httpPost, responseHandler);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return address;
	}

	static public void sendPostAndHead(){
		
	}
static public String getWeather(String url, String apiKey, String city) {
		String param = "key=" + apiKey + "&city=" + city;
		String result = SendURLAndParam(url, "GET", param);
		return result;
	}
static public void SMS(String url,String apiKey,int tplid,String tel,String wd) throws UnsupportedEncodingException {
		
	wd = URLEncoder.encode(wd,"UTF-8");//url编码 不是必须 看具体接口需要
	String param = "key="+apiKey+"&tplid="+tplid+"&tel="+tel+"&wd="+wd;

	String res = SendURLAndParam(url, "GET",param);
	System.out.println(res);
}

static public String sendSMSWithBmob(String tel,String template,String code) {	
	String postData =JsonUtils.objectToJson(new SMS(tel,template));
	System.out.println(postData);
	Map<String, String> head = new HashMap();
	head.put("X-Bmob-Application-Id", "18695e4d334a25516ad2ca30c3a63c83");
	head.put("X-Bmob-REST-API-Key", "ee6560587d3096d6bd2c19765a5dc91b");
	String res = httpPost(" https://api.bmob.cn/1/requestSmsCode", head,postData,null);
	return res;
}
public static void main(String[] args) {
	String res = sendSMSWithBmob("18734741443", "注册模板", "145365");
	System.out.println(res);
}	
static	public class SMS {
	public	String mobilePhoneNumber="18734741443";
	public	String template = "注册模板";
	public SMS(String mobilePhoneNumber, String template) {
		super();
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.template = template;
	}

	}
static public String getSixRandom() {
	String s = String.valueOf((Math.random()*9+1)*100000);	
	return s;
}
}
