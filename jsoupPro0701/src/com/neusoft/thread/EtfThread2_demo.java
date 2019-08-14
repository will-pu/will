package com.neusoft.thread;

import java.util.List;

import com.neusoft.bean.Etfjin;
import com.neusoft.jsoup.JsoupTools;
import com.neusoft.service.EtfjinService;
import com.neusoft.service.impl.EtfjinServiceBean;
import com.neusoft.test.Tools;

public class EtfThread2_demo extends Thread {
	
	public static int x=100;
	
	public static void setX(int y){
		EtfThread2_demo.x=y;
	}
	
	@Override
	public void run() {
		int count=0;
		while(true){
			try {
				System.out.println("count="+count);
				System.out.println("x="+x);
			//	System.out.println((Tools.map.get("etf")).getTime());
				sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			if(count>100){
				break;
			}
		}
	}
}
