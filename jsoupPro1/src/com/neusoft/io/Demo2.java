package com.neusoft.io;

import java.io.File;
import java.io.IOException;

public class Demo2 {

	public static void main(String[] args) {
		File file=new File("e:/a/a.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("over");
	}

}
