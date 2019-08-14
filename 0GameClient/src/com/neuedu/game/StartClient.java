package com.neuedu.game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class StartClient {
	
	public static void main(String[] args) {
		//建议IP和端口通过配置文件获取
		try {
			Socket s = new Socket("localhost", 40000);
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());//处理输出流
			DataInputStream dis = new DataInputStream(s.getInputStream());//处理输入流
			
			while(true) {
				/*
				 * 数据库表players表， 账号，密码，最好时间
				 * 
				 * 1. 用户输入账号和密码  登录       
				 * 2. 注册
				 * 
				 * 3. 开始游戏 - 猜数字
				 * 4. 查看排名
				 * 
				 * 5. 退出
				 */
				
				System.out.println("1 - 登录");
				System.out.println("2 - 注册");
				System.out.println("9 - 退出");
				System.out.println("请选择：");
				Scanner sc1 = new Scanner(System.in);
				int s1 = sc1.nextInt();
				if(s1 == 1) {
					//登录
					//1.提示用户输入账号
					Scanner sc2 = new Scanner(System.in);
					System.out.println("请输入账号:");
					String account = sc2.nextLine();
					//2.提示用户输入密码
					Scanner sc3 = new Scanner(System.in);
					System.out.println("请输入密码:");
					String apass = sc3.nextLine();
					//3.将账号和密码发送给服务器   （服务器验证）
					dos.writeUTF(100+","+account+","+apass);
					dos.flush();
					//4.接收服务器的验证结果   NG-重新执行该界面
					String rec = dis.readUTF();
					if(rec.equals("OK")) {
						//OK- 进入下一个界面
						while(true) {
							System.out.println("1 - 开始游戏");
							System.out.println("2 - 查看排名");
							System.out.println("9 - 退出");
							System.out.println("请选择：");
							Scanner sc4 = new Scanner(System.in);
							int s2 = sc4.nextInt();
							if(s2 == 1) {
								//开始游戏
								//1.发送指令，服务器生成随机数字
								dos.writeUTF(103+",");
								dos.flush();
								
								String rec1 = dis.readUTF();
								if(rec1.equals("OK")) {
									//2.开始猜
									while(true) {
										Scanner sc5 = new Scanner(System.in);
										System.out.println("请输入猜测的四位数（投降请输入-1）：");
										int guess = sc5.nextInt();
										if(guess == -1) {
											//(2)投降 -1
											dos.writeUTF(105+",");
											dos.flush();
											
											String rec2 = dis.readUTF();
											System.out.println("服务器生成的数字是:"+rec2);
											break;
										}else {
											//(1)输入数字 - 猜
											dos.writeUTF(104+","+guess);
											dos.flush();
											
											String rec2 = dis.readUTF();
											System.out.println("比较结果："+rec2);
											if(rec2.equals("4A0B")) {
												System.out.println("恭喜您猜对了");
												break;
											}
										}
									}
									
								}else {
									System.out.println("服务器出现问题");
								}
								
							}else if(s2 == 2) {
								//查看排名
								dos.writeUTF(106+",");
								dos.flush();
								
								//接收消息
								String rec2 = dis.readUTF();
								String[] ps = rec2.split(";");
								for(String p : ps) {
									String[] ts = p.split(",");
									for(String t : ts) {
										System.out.print(t);
										System.out.print("\t");
									}
									System.out.println();
								}
								
								
							}else if(s2 == 9) {
								//退出
								dos.writeUTF(102+",");
								dos.flush();
								System.exit(0);
							}
						}	
					}else {
						System.out.println("账号密码错误");
					}
					
				}else if(s1 == 2) {
					//注册
					//1.提示用户输入账号
					Scanner sc2 = new Scanner(System.in);
					System.out.println("请输入账号:");
					String account = sc2.nextLine();
					//2.提示用户输入密码
					Scanner sc3 = new Scanner(System.in);
					System.out.println("请输入密码:");
					String apass = sc3.nextLine();
					//3.将账号和密码发送给服务器   （服务器保存）
					dos.writeUTF(101+","+account+","+apass);
					dos.flush();
					
					//4.接收服务器的验证结果   
					String rec = dis.readUTF();
					if(rec.equals("OK")) {
						//注册成功
						System.out.println("注册成功");
					}else {
						System.out.println("注册失败：账号被使用");
					}
				}else if(s1 == 9) {
					//退出
					dos.writeUTF(102+",");
					dos.flush();
					break;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
