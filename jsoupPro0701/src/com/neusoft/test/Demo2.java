package com.neusoft.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.neusoft.jsoup.JsoupTools;

public class Demo2 {

	public static void main(String[] args) {
		JsoupTools t=new JsoupTools();
		String urlpath="http://www.dyhjw.com/dyhjw/etf.html";
		String charset="utf-8";
		String html=t.getHtml(urlpath, charset);
		Document document=Jsoup.parse(html);
		//System.out.println(doc);
		//Elements tables = doc.getElementsByClass("sx_table");
		//System.out.println(tables);
		System.out.println("==============");
		/** 创建一个FileWriter 对象 */
		FileWriter fw;
		try {
			fw = new FileWriter("e:/ETF.txt");
			/** 创建一个BufferedWriter 对象 */
			BufferedWriter bw = new BufferedWriter(fw);
			Elements trs = document.select("table").select("tr");
			int i;
			for (i = 0; i < trs.size(); i++) {
				Elements tds = trs.get(i).select("td");
				String str="";
				for (int j = 0; j < tds.size(); j++) {
					String txt = tds.get(j).text();
					System.out.print(txt + "\t");
					str=str+txt+"\t";
				}
				System.out.println();
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
