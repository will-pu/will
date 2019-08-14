package com.neusoft.thread;

import java.util.List;

import com.neusoft.bean.Etfjin;
import com.neusoft.jsoup.JsoupTools;
import com.neusoft.service.EtfjinService;
import com.neusoft.service.impl.EtfjinServiceBean;

public class EtfThread2 extends Thread {
	private EtfjinService etf_jinService=new EtfjinServiceBean();
	@Override
	public void run() {
		int count=0;
		while(true){
			JsoupTools t=new JsoupTools();
			String urlpath="http://www.dyhjw.com/dyhjw/etf.html";
			String charset="utf-8";
			String html=t.getHtml(urlpath, charset);
			List<Etfjin> list=t.getEtf_jinListTop10(html);
			
			boolean isOK=etf_jinService.setEtid2(list);
			
			System.out.println("count="+count);
			System.out.println("EtfThread....isOK="+isOK);
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
	}
}