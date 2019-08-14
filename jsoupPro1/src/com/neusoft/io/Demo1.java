package com.neusoft.io;

import java.io.File;
import java.util.Date;

public class Demo1 {

	public static void main(String[] args) {
	//	File file = new File("E:/p");
		File file = new File("E:/0813.txt");
		if (file.exists()) {// 判断文件是否存在
			System.out.println("是文件吗:" + file.isFile());
			System.out.println("是目录吗:" + file.isDirectory());
			System.out.println("名称:" + file.getName());
			System.out.println("路径: " + file.getPath());
			System.out.println("最后修改时间:" +new Date(file.lastModified()) );
			System.out.println("文件大小:" + file.length() + " 字节");
		}else{
			System.out.println("不存在");
		}
	}

}
