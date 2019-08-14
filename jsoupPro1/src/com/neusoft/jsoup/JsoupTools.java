package com.neusoft.jsoup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.neusoft.bean.Etfjin;
import com.neusoft.bean.Etfyin;

public class JsoupTools {
	public String getHtml(String urlpath, String charset) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(urlpath);
			URLConnection conn = url.openConnection();

			InputStream in = conn.getInputStream();
			// 字节流-》字符流 InputStreamReader
			InputStreamReader reader = new InputStreamReader(in, charset);
			// 按行读
			BufferedReader breader = new BufferedReader(reader);
			// 读
			String line = "";
			while ((line = breader.readLine()) != null) {
				buffer.append(line);
				// System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("读取" + urlpath + "链接出现问题");
			e.printStackTrace();
		}

		return buffer + "";
	}

	public List<Etfjin> getEtf_jinList(String html) {
		List<Etfjin> list = new ArrayList<>();
		Document document = Jsoup.parse(html);
		Elements trs = document.select("table").select("tr");
		int i;
		for (i = 1; i < trs.size(); i++) {
			Etfjin jin=new Etfjin();
			Elements tds = trs.get(i).select("td");
	//		System.out.println(tds.get(0).text());
			jin.setTime(this.setTime(tds.get(0).text()));
			jin.setJingChiCangLiang(Double.parseDouble(tds.get(1).text()) );
			jin.setMeiYuan(Double.parseDouble(tds.get(2).text()));
			jin.setZengJian(Double.parseDouble(tds.get(3).text()));
			jin.setYingXiang(tds.get(4).text());
			jin.setPrice(this.getPrice(jin.getMeiYuan(), jin.getJingChiCangLiang()));
			list.add(jin);
		}
		return list;
	}
	public List<Etfjin> getEtf_jinListTop10(String html) {
		List<Etfjin> list = new ArrayList<>();
		Document document = Jsoup.parse(html);
		Elements trs = document.select("table").select("tr");
		int i;
		for (i = 1; i < 11; i++) {
			Etfjin jin=new Etfjin();
			Elements tds = trs.get(i).select("td");
	//		System.out.println(tds.get(0).text());
			jin.setTime(this.setTime(tds.get(0).text()));
			jin.setJingChiCangLiang(Double.parseDouble(tds.get(1).text()) );
			jin.setMeiYuan(Double.parseDouble(tds.get(2).text()));
			jin.setZengJian(Double.parseDouble(tds.get(3).text()));
			jin.setYingXiang(tds.get(4).text());
			jin.setPrice(this.getPrice(jin.getMeiYuan(), jin.getJingChiCangLiang()));
			list.add(jin);
		}
		return list;
	}
	public double getPrice(double meiYuan,double jingChiCangLiang){
		double price=0;
		price=meiYuan/jingChiCangLiang/32150;
		return price;
	}
	public void saveETF_jinFile(List<Etfjin> list,String path){
		/** 创建一个FileWriter 对象 */
		FileWriter fw;
		try {
			fw = new FileWriter(path);
			/** 创建一个BufferedWriter 对象 */
			BufferedWriter bw = new BufferedWriter(fw);
			for(Etfjin j:list){
				String str="";
				str=j.getTime()+"\t"+j.getJingChiCangLiang()+
						"\t"+j.getMeiYuan()+"\t"+j.getZengJian()+"\t"+j.getYingXiang()+
						"\t"+j.getPrice()+"\t"+j.getTime2();
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
	public void showListETF_jin(List<Etfjin> list){
		for(Etfjin j:list){
			System.out.println(j.getId()+"\t"+j.getTime()+"\t"+j.getJingChiCangLiang()+
					"\t"+j.getMeiYuan()+"\t"+j.getZengJian()+"\t"+j.getYingXiang()+
					"\t"+j.getPrice()+"\t"+j.getTime2());
		}
	}
	public String setTime(String time){
		time=time.replaceAll("年", "-");
		time=time.replaceAll("月", "-");
		time=time.replaceAll("日", "");
		return time;
	}
	public List<Etfyin> getEtf_yinList(String html) {
		List<Etfyin> list = new ArrayList<>();
		Document document = Jsoup.parse(html);
		Elements trs = document.select("table").select("tr");
		int i;
		for (i = 1; i < trs.size(); i++) {
			Etfyin jin=new Etfyin();
			Elements tds = trs.get(i).select("td");
	//		System.out.println(tds.get(0).text());
			jin.setTime(this.setTime(tds.get(0).text()));
			jin.setJingChiCangLiang(Double.parseDouble(tds.get(1).text()) );
			jin.setMeiYuan(Double.parseDouble(tds.get(2).text()));
			jin.setZengJian(Double.parseDouble(tds.get(3).text()));
			jin.setYingXiang(tds.get(4).text());
			jin.setPrice(this.getPrice(jin.getMeiYuan(), jin.getJingChiCangLiang()));
			list.add(jin);
		}
		return list;
	}
	public List<Etfyin> getEtf_yinListTop10(String html) {
		List<Etfyin> list = new ArrayList<>();
		Document document = Jsoup.parse(html);
		Elements trs = document.select("table").select("tr");
		int i;
		for (i = 1; i < 11; i++) {
			Etfyin jin=new Etfyin();
			Elements tds = trs.get(i).select("td");
	//		System.out.println(tds.get(0).text());
			jin.setTime(this.setTime(tds.get(0).text()));
			jin.setJingChiCangLiang(Double.parseDouble(tds.get(1).text()) );
			jin.setMeiYuan(Double.parseDouble(tds.get(2).text()));
			jin.setZengJian(Double.parseDouble(tds.get(3).text()));
			jin.setYingXiang(tds.get(4).text());
			jin.setPrice(this.getPrice(jin.getMeiYuan(), jin.getJingChiCangLiang()));
			list.add(jin);
		}
		return list;
	}
	
	public void saveETF_yinFile(List<Etfyin> list,String path){
		/** 创建一个FileWriter 对象 */
		FileWriter fw;
		try {
			fw = new FileWriter(path);
			/** 创建一个BufferedWriter 对象 */
			BufferedWriter bw = new BufferedWriter(fw);
			for(Etfyin j:list){
				String str="";
				str=j.getTime()+"\t"+j.getJingChiCangLiang()+
						"\t"+j.getMeiYuan()+"\t"+j.getZengJian()+"\t"+j.getYingXiang()+
						"\t"+j.getPrice()+"\t"+j.getTime2();
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
	public void showListETF_yin(List<Etfyin> list){
		for(Etfyin j:list){
			System.out.println(j.getId()+"\t"+j.getTime()+"\t"+j.getJingChiCangLiang()+
					"\t"+j.getMeiYuan()+"\t"+j.getZengJian()+"\t"+j.getYingXiang()+
					"\t"+j.getPrice()+"\t"+j.getTime2());
		}
	}
	
}
