package com.neusoft.test;

import com.neusoft.bean.Etfjin;
import com.neusoft.thread.EtfThread2;

public class Demo8 {

	public static void main(String[] args) {
		Etfjin e=new Etfjin();
		e.setTime("2019-06-27");
		e.setMeiYuan(40000);
		Tools.map.put("etf", e);
		System.out.println("demo8===="+(Tools.map.get("etf")).getTime());
		
		
	}

}
