package com.neusoft.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FilteTools {

//	public boolean log(List<Student> list, String path) {
//		boolean isOK = false;
//		FileWriter fw;
//		this.createNewFile(path);
//		try {
//			fw = new FileWriter(path, true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.newLine();
//			Date time=new Date();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String str_time=sdf.format(time);
//			bw.write(str_time);
//			bw.newLine();
//			for (int i = 0; i < list.size(); i++) {
//				Student stu = list.get(i);
//				String name = stu.getName();
//				for (int j = 0; j < list.size(); j++) {
//					if (name.equals((list.get(j)).getName()) && i != j) {
//					//	System.out.println(name + "\t" + stu.getId() + "\t" + i);
//						String str = (stu.getId() + " " + stu.getName() + " " + 
//								stu.getAge() + " " + stu.getSex() + " "+ 
//								stu.getGrade() );
//						bw.write(str);
//						bw.newLine();
//						break;
//					}
//				}
//			}
//			bw.flush();
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return isOK;
//	}
//
//	public boolean xieWenJian(Object obj[], String path) {
//		boolean isOK = false;
//
//		FileWriter fw;
//		try {
//			fw = new FileWriter(path);
//			BufferedWriter bw = new BufferedWriter(fw);
//			for (Object x : obj) {
//				Student stu = (Student) x;
//				String str = (stu.getId() + " " + stu.getName() + " " + stu.getAge() + " " + stu.getSex() + " "
//						+ stu.getGrade() );
//				bw.write(str);
//				bw.newLine();
//			}
//			bw.flush();
//			fw.close();
//			isOK = true;
//			System.out.println("排序后写入数据完成");
//		} catch (IOException e) {
//			isOK = false;
//			System.out.println("写入数据异常");
//			e.printStackTrace();
//		}
//
//		for (Object x : obj) {
//			Student stu = (Student) x;
////			System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getSex() + "\t"
////					+ stu.getGrade() + "\t" );
//		}
//		return isOK;
//	}
//
//	public Object[] paiXu(List<Student> stuList) {
//		Object obj[] = stuList.toArray();
//		Object temp = null;
//		for (int i = 0; i < obj.length; i++) {
//			for (int j = 0; j < obj.length - 1; j++) {
//				// Student stu=(Student)obj[j];
//				if (((Student) obj[j]).getGrade() < ((Student) obj[j + 1]).getGrade()) {
//					temp = obj[j];
//					obj[j] = obj[j + 1];
//					obj[j + 1] = temp;
//				}
//			}
//		}
//		// for(Object x:obj){
//		// Student stu=(Student)x;
//		// System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+
//		// stu.getAge()+"\t"+stu.getSex()+"\t"+stu.getGrade()+"\t"+
//		// stu.getTel());
//		// }
//
//		return obj;
//	}
//
//	public List<Student> setList(String path) {
//		List<Student> list = new ArrayList<Student>();
//		FileReader fr;
//		try {
//			fr = new FileReader(path);
//			BufferedReader br = new BufferedReader(fr);
//			String s = br.readLine();
//			while (s != null) {
//				Student stu = new Student();
//				int i = 0;
//				String str[] = new String[5];
//				String x = "";
//				int index = 0;
//				while (i < 4) {
//					index = s.indexOf(" ");
//					x = s.substring(0, index);
//				//	System.out.println("x="+x);
//					str[i] = x;
//					s = s.substring(index + 1);
//				//	System.out.println(s);
//					i++;
//				}
//				str[4] = s;
//	//			System.out.println(str[0]+"\t"+str[1]+"\t"+str[2]+"\t"+str[3]+"\t"+str[4]);
//				stu.setId(str[0]);
//				stu.setName(str[1]);
//				stu.setAge(Integer.parseInt(str[2]));
//				stu.setSex(str[3]);
//				stu.setGrade(Float.parseFloat(str[4]));
//				
//
//				list.add(stu);
//
//				s = br.readLine();
//			}
//			br.close();
//			fr.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	//读文件
	public String getEtfTime(String path) {
		String time="";
		FileReader fr;
		try {
			fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			time = br.readLine();
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	//写文件
	public boolean setEtfTime(String path,String time) {
	boolean isOK = false;
		// String path="E:/ETF/ETF_newTime.txt";
	FileWriter fw;
	this.createNewFile(path);
	try {
		fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(time);
		bw.flush();
		fw.close();
		isOK=true;
	} catch (IOException e) {
		isOK=false;
		e.printStackTrace();
	}
	return isOK;
}
	
	public boolean copy(String path, String newPath) {
		boolean isOK = false;
		byte b[] = this.ctrl_c(path);
		isOK = this.ctrl_v(b, newPath);
		return isOK;
	}

	public byte[] ctrl_c(String path) {
		byte b[] = null;
		FileInputStream f;
		try {
			f = new FileInputStream(path);
			int size = f.available();
			b = new byte[size];
			for (int i = 0; i < size; i++) {
				b[i] = (byte) f.read();
			}
			f.close();// 关闭文件输入流对象
		} catch (IOException e) {
			System.out.println("读取文件异常");
			e.printStackTrace();
		}
		System.out.println("b.length=" + b.length);
		return b;
	}

	public boolean ctrl_v(byte b[], String path) {
		boolean isOK = false;

		FileOutputStream fos;
		try {
			boolean ok = this.createNewFile(path);
			if (ok) {
				fos = new FileOutputStream(path);
				fos.write(b);
				System.out.println("文件写入成功");
				fos.close();
				isOK = true;
			} else {
				System.out.println("创建文件路径出现异常，请重新操作!");
				isOK = false;
			}

		} catch (IOException e) {
			isOK = false;
			System.out.println("写入文件异常");
			e.printStackTrace();
		}

		return isOK;
	}

	public boolean createNewFile(String path) {
		boolean isOK = false;
		char c[] = path.toCharArray();
		int index = 0;
		for (int i = c.length - 1; i > 0; i--) {
			System.out.print(c[i] + " ");
			if ('/' == c[i]) {
				index = i;
				break;
			}
		}
		String fileName = path.substring(index + 1);
		System.out.println("\nfileName=" + fileName);
		String newPath = path.substring(0, index);
		System.out.println("newPath=" + newPath);
		System.out.println("index=" + index);

		File f = new File(newPath);
		if (f.exists()) {
			System.out.println("文件夹存在");
		} else {
			System.out.println("文件夹不存在");
			boolean isOK2 = f.mkdirs();
		}
		try {
			File file = new File(path);
			isOK = file.createNewFile();
			if (isOK) {
				System.out.println("创建文件成功");
			} else {
				System.out.println("创建文件不成功");
			}
		} catch (IOException e) {
			isOK = false;
			e.printStackTrace();
		}
		System.out.println("isOK=" + isOK);
		return isOK;
	}
	public long findTime(String path){
		File f = new File(path);
		long time=f.lastModified();
		return time;
	}
//	public List<Student> findList1_List2(List<Student> listA,List<Student> listB){
//		System.out.println("======findList1_List2=====比较筛选======");
//		List<Student> list=new ArrayList<>();
//		for(int i=listA.size();i<listB.size();i++){
//			Student s=listB.get(i);
//	//		System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getSex()+"\t"+s.getAge()+"\t"+s.getGrade());
//			list.add(s);
//		}
//		return list;
//	}
	
	public String getKaiGuan(String path) {
		String isOK="false";
		FileReader fr;
		try {
			fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			isOK = br.readLine();
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOK;
	}
	/*
	 * 设置开关变量
	 * true表示关闭
	 * false表示开始
	 */
	public void setKaiGuan( String path,String isOK) {
		
		FileWriter fw;
		try {
			fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(isOK);
			bw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println("写入数据异常isOK="+isOK);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		FilteTools t = new FilteTools();
		String path = "E:/集合.png";
		String newPath = "d:/a/b/集合2.png";
		boolean isOK = t.copy(path, newPath);
		if (isOK) {
			System.out.println("复制成功");
		} else {
			System.out.println("复制失败");
		}

	}
}
