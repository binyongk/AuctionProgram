package com.yb.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class AdminCom implements Runnable {

	ServerSocket ss;
	Vector<Service> v;
	
	public AdminCom() {
		
		System.out.println("����������...");
		
		v = new Vector<>();
		
		try {
			ss = new ServerSocket(3000);
			new Thread(this).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public void run() {  //���� Ŭ���̾�Ʈ ������ ���� wait
		try {
			while(true) {
				Socket s = ss.accept(); 
				v.add(new Service(s));
			}
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	class Service extends Thread{
		BufferedReader in;
		OutputStream out;
		
		String Nickname;
		
		public Service() {
			//in = new BufferedReader(new InputStreamReader())
		}
	}
}
