package com.neusoft.test;

public class Demo5 {

	public static void main(String[] args) {
		String str="2019年05月3日";
		str=str.replaceAll("年", "-");
		str=str.replaceAll("月", "-");
		str=str.replaceAll("日", "");
		
		System.out.println(str);

	}

}
