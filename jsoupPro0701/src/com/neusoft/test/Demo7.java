package com.neusoft.test;

import com.neusoft.bean.Etfjin;
import com.neusoft.thread.EtfThread2;

public class Demo7 {

	public static void main(String[] args) {
		Etfjin e = new Etfjin();
		e.setTime("2019-06-26");
		e.setMeiYuan(50000);
		Tools.map.put("etf", e);
		// System.out.println((Tools.map.get("etf")).getTime());

		EtfThread2 t = new EtfThread2();
		t.start();
		System.out.println(".........1....................");
		Etfjin e1 = new Etfjin();
		e1.setTime("2019-06-27");
		e1.setMeiYuan(40000);
		Tools.map.put("etf", e1);
		for(int i=0;i<100;i++){
			System.out.println("i="+i);
		}

	}

}
