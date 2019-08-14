package com.neusoft.thread;

import java.util.List;

import com.neusoft.bean.Etfyin;
import com.neusoft.jsoup.JsoupTools;
import com.neusoft.service.EtfyinService;
import com.neusoft.service.impl.EtfyinServiceBean;

public class EtfThread extends Thread {
	private EtfyinService etf_yinService=new EtfyinServiceBean();
	public static boolean exit = true;
	
	@Override
	public void run() {
		int count=0;
		while(exit){
			JsoupTools t=new JsoupTools();
			String urlpath="http://www.dyhjw.com/dyhjw/slv_etf.html";
			String charset="utf-8";
			String html=t.getHtml(urlpath, charset);
			List<Etfyin> list=t.getEtf_yinListTop10(html);
			boolean isOK=etf_yinService.setEtid(list);
			System.out.println("count="+count);
			System.out.println("EtfThread....isOK="+isOK);
			try {
				sleep(50000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			count++;
		}
		
	}
}
