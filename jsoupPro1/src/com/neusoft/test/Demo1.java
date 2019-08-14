package com.neusoft.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		StringBuffer buffer = new StringBuffer();
		String urlPath="https://sou.zhaopin.com/?jl=599&kw=java&kt=3";
	//	String urlPath = "http://www.dyhjw.com/dyhjw/etf.html";
	//	String urlPath="http://stock.finance.sina.com.cn/futures/view/vGoldEtf.php";
	//	String urlPath="http://stock2.finance.sina.com.cn/futures/api/jsonp.php/var%20info=/GoldEtfService.getGoldEtfData?code=1&startdate=2018-01-17&enddate=2018-07-10&page=2";
		URL url = new URL(urlPath);
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
	}
}
