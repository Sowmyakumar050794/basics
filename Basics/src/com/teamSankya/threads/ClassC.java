package com.teamSankya.threads;

public class ClassC  implements A{
		public  void m2() 
		{
			System.out.println("inside m2");
		}
		public   void m3() 
		{
			System.out.println("inside m3");
		}
		public static void main(String[] args) {

			ClassC c = new ClassC();
			c.m2();
			c.m3();
			try {
				c.m1();
			} catch (Error e) {
				// TODO Auto-generated catch block
				System.out.println("jgasf");
			}
			/*m2();
			m3();
			m1*/
			

		}
		@Override
		public void m1() {
			// TODO Auto-generated method stub
			
		}

	}



