
package com.teamSankya.threads;

public class ClassB {
	
		static public void m() {
			/*System.out.println("mmm");*/
			m();
		}

		public static void main(String[] args) {
			try {
				m();
			} catch (Error e) {
				System.out.println("exception handling");
				//e.printStackTrace();
			}
		}
	}



