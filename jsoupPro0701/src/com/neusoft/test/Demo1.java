package com.neusoft.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		StringBuffer buffer = new StringBuffer();
	//	String urlpath = "http://www.dyhjw.com/dyhjw/etf.html";
	//	String urlpath="http://stock.finance.sina.com.cn/futures/view/vGoldEtf.php";
	//	String urlpath="http://stock2.finance.sina.com.cn/futures/api/jsonp.php/var%20info=/GoldEtfService.getGoldEtfData?code=1&startdate=2019-01-1&enddate=2019-06-24&page=1";
		String urlpath = "https://sou.zhaopin.com/?jl=%E5%8C%97%E4%BA%AC&kw=java&kt=3&sf=0&st=0";
		URL url = new URL(urlpath);
		URLConnection conn = url.openConnection();

		InputStream in = conn.getInputStream();
		// 字节流-》字符流 InputStreamReader
		InputStreamReader reader = new InputStreamReader(in, "utf-8");
		// 按行读
		BufferedReader breader = new BufferedReader(reader);
		// 读
		String line = "";
		while ((line = breader.readLine()) != null) {
			buffer.append(line);
			System.out.println(line);
		}
		System.out.println("over");
	}
}
