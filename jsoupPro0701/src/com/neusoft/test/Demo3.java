package com.neusoft.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.neusoft.bean.Etfjin;
import com.neusoft.jsoup.JsoupTools;

public class Demo3 {

	public static void main(String[] args) {
		JsoupTools t=new JsoupTools();
		String urlpath="http://www.dyhjw.com/dyhjw/etf.html";
		String charset="utf-8";
		String html=t.getHtml(urlpath, charset);
		List<Etfjin> list=t.getEtf_jinList(html);
		String path="e:/ETF_jin.txt";
		t.saveETF_jinFile(list, path);
		t.showListETF_jin(list);
		System.out.println("over");
	}
}
