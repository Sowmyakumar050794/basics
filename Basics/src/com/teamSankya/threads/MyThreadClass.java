package com.teamSankya.threads;

public class MyThreadClass {
	

		public static void main(String[] args) {
			System.out.println("started");
			MyThread dt = new MyThread();
			dt.setDaemon(true);
			System.out.println(dt.isDaemon());
			dt.start();
			
			System.out.println("ended");
		}

	}



