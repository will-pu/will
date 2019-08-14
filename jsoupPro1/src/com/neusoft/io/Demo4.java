package com.neusoft.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4 {

	public static void main(String[] args) {
		 try {                 
	            String str ="hello123546";
	            byte[] words  = str.getBytes();
	            FileOutputStream fos = new FileOutputStream("e:/b.txt",true);
	            fos.write(words);
	            System.out.println("Text文件已更新!");
	            fos.close();
	       } catch (IOException obj) {
	                 System.out.println("创建文件时出错!");
	       }


	}

}
