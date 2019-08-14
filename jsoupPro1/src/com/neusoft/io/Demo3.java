package com.neusoft.io;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo3 {

	public static void main(String[] args) throws IOException {
	    //创建一个 FileInputStream对象
		FileInputStream f = new FileInputStream("e:/0813.txt");
	   // 确定文件的大小
		int size = f.available(); 	
		for (int i = 0; i < size; i++) {
	            //使用 read()方法一次读取一个字符，然后将字符输出
			//System.out.print((char)f.read());
			
		}
		int a[]= {(char)f.read()};
		int temp;	
		for(int i =1;i<a.length;i++) { 
            for(int j=0;j<a.length-i;j++) {
                if(a[j]>a[j+1]) {
                    temp = a[j];                     
                    a[j]=a[j+1];                    
                    a[j+1]=temp;
                }
            }
		}
		for(int i = 0; i < a.length; i++) {
				System.out.print(a[i]+",");
			}
			
		f.close();//关闭文件输入流对象
	}	

}
