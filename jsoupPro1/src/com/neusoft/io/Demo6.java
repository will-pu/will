package com.neusoft.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo6 {

	public static void main(String[] args) throws IOException {
	     /**创建一个FileWriter 对象*/
	       FileWriter fw=new FileWriter("e:/c.txt",true); 
	       /**创建一个BufferedWriter 对象*/
	       BufferedWriter bw=new BufferedWriter(fw); 
	       
	       bw.write("大家好！"); 
	       bw.write("我正在学习BufferedWriter。"); 
	       bw.newLine(); 
	       bw.write("请多多指教！"); 
	       bw.newLine();
	       bw.write("email: lodestar0616@163.com"); 
	       bw.flush();
	       fw.close();
	       System.out.println("over");
	}
}
