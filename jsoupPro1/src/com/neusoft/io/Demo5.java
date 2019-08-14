package com.neusoft.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo5 {

	public static void main(String[] args) throws Exception {
		 /**创建一个FileReader对象.*/
        FileReader fr=new FileReader("e:/f.txt"); 

        /**创建一个BufferedReader 对象.*/
        BufferedReader br=new BufferedReader(fr); 

        /**读取一行数据.*/ 
        String line=br.readLine();

        while(line!=null){ 
            System.out.println(line);
            line=br.readLine(); /**读取下一行数据.*/ 
        }

         /**流的关闭.*/ 
        br.close();
        fr.close(); 


	}

}
