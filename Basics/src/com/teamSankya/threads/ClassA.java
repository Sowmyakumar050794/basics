package com.teamSankya.threads;

public class ClassA {
	
		static int count =1;
		@Override
		protected void finalize() throws Throwable {

			super.finalize();
			System.out.println("this is finalize method"+count++);
		}
		public static void main(String[] args) {
			for (int i = 0; i < 1000000; i++) {
				new ClassA();
			} 
			
			
	System.out.println("aaaa");
		}
	}



