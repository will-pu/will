package com.neuedu.game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class StartClient {
	
	public static void main(String[] args) {
		//����IP�Ͷ˿�ͨ�������ļ���ȡ
		try {
			Socket s = new Socket("localhost", 40000);
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());//���������
			DataInputStream dis = new DataInputStream(s.getInputStream());//����������
			
			while(true) {
				/*
				 * ���ݿ��players�� �˺ţ����룬���ʱ��
				 * 
				 * 1. �û������˺ź�����  ��¼       
				 * 2. ע��
				 * 
				 * 3. ��ʼ��Ϸ - ������
				 * 4. �鿴����
				 * 
				 * 5. �˳�
				 */
				
				System.out.println("1 - ��¼");
				System.out.println("2 - ע��");
				System.out.println("9 - �˳�");
				System.out.println("��ѡ��");
				Scanner sc1 = new Scanner(System.in);
				int s1 = sc1.nextInt();
				if(s1 == 1) {
					//��¼
					//1.��ʾ�û������˺�
					Scanner sc2 = new Scanner(System.in);
					System.out.println("�������˺�:");
					String account = sc2.nextLine();
					//2.��ʾ�û���������
					Scanner sc3 = new Scanner(System.in);
					System.out.println("����������:");
					String apass = sc3.nextLine();
					//3.���˺ź����뷢�͸�������   ����������֤��
					dos.writeUTF(100+","+account+","+apass);
					dos.flush();
					//4.���շ���������֤���   NG-����ִ�иý���
					String rec = dis.readUTF();
					if(rec.equals("OK")) {
						//OK- ������һ������
						while(true) {
							System.out.println("1 - ��ʼ��Ϸ");
							System.out.println("2 - �鿴����");
							System.out.println("9 - �˳�");
							System.out.println("��ѡ��");
							Scanner sc4 = new Scanner(System.in);
							int s2 = sc4.nextInt();
							if(s2 == 1) {
								//��ʼ��Ϸ
								//1.����ָ������������������
								dos.writeUTF(103+",");
								dos.flush();
								
								String rec1 = dis.readUTF();
								if(rec1.equals("OK")) {
									//2.��ʼ��
									while(true) {
										Scanner sc5 = new Scanner(System.in);
										System.out.println("������²����λ����Ͷ��������-1����");
										int guess = sc5.nextInt();
										if(guess == -1) {
											//(2)Ͷ�� -1
											dos.writeUTF(105+",");
											dos.flush();
											
											String rec2 = dis.readUTF();
											System.out.println("���������ɵ�������:"+rec2);
											break;
										}else {
											//(1)�������� - ��
											dos.writeUTF(104+","+guess);
											dos.flush();
											
											String rec2 = dis.readUTF();
											System.out.println("�ȽϽ����"+rec2);
											if(rec2.equals("4A0B")) {
												System.out.println("��ϲ���¶���");
												break;
											}
										}
									}
									
								}else {
									System.out.println("��������������");
								}
								
							}else if(s2 == 2) {
								//�鿴����
								dos.writeUTF(106+",");
								dos.flush();
								
								//������Ϣ
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
								//�˳�
								dos.writeUTF(102+",");
								dos.flush();
								System.exit(0);
							}
						}	
					}else {
						System.out.println("�˺��������");
					}
					
				}else if(s1 == 2) {
					//ע��
					//1.��ʾ�û������˺�
					Scanner sc2 = new Scanner(System.in);
					System.out.println("�������˺�:");
					String account = sc2.nextLine();
					//2.��ʾ�û���������
					Scanner sc3 = new Scanner(System.in);
					System.out.println("����������:");
					String apass = sc3.nextLine();
					//3.���˺ź����뷢�͸�������   �����������棩
					dos.writeUTF(101+","+account+","+apass);
					dos.flush();
					
					//4.���շ���������֤���   
					String rec = dis.readUTF();
					if(rec.equals("OK")) {
						//ע��ɹ�
						System.out.println("ע��ɹ�");
					}else {
						System.out.println("ע��ʧ�ܣ��˺ű�ʹ��");
					}
				}else if(s1 == 9) {
					//�˳�
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
