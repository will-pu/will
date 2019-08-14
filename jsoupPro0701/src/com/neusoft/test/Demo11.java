package com.neusoft.test;

import com.neusoft.tools.FilteTools;

public class Demo11 {

	public static void main(String[] args) {
		
		FilteTools f=new FilteTools();
		String path="E:/ETF/ETF_newTime.txt";
	//	boolean isOK=f.setEtfTime(path,"2019-06-28");
	//	System.out.println("isOK="+isOK);
		String time=f.getEtfTime(path);
		System.out.println("time="+time);
	}

}
