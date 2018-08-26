package com.teamSankya.collections;

public class TestArrayList{

	public static void main(String[] args) {
		MyArrayList ar = new MyArrayList(10);

		ar.add(1);
		ar.add(2);
		ar.add(3);
		ar.add(4);
		ar.add(5);
		ar.remove(3);
	

		for (int i = 0; i < ar.getSize(); i++) {
			System.out.println(ar.get(i));
			
		}


	}



}
