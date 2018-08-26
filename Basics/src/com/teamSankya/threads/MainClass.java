package com.teamSankya.threads;

public class MainClass {

	
		int a= 55;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			return result;
		}

		@Override
		public String toString() {
			return "Main [a=" + a + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
					+ super.toString() + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MainClass other = (MainClass) obj;
			if (a != other.a)
				return false;
			return true;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	MainClass main =new MainClass();
	System.out.println(main.toString());
	System.out.println(main.hashCode());

		}

	}



