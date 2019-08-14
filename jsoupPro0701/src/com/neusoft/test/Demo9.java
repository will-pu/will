package com.neusoft.test;

import com.neusoft.bean.Etfjin;
import com.neusoft.thread.EtfThread2;

public class Demo9 {

	public static void main(String[] args) {
		
		EtfThread2 t=new EtfThread2();
		t.start();
		EtfThread2 t2=new EtfThread2();
		t2.start();
		
	}

}
