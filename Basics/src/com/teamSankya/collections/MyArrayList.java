package com.teamSankya.collections;

import java.util.Arrays;

public class MyArrayList {

	private static final int DEFAULT_CAPACITY = 10;
	private int capacity;
	private static final int DEFAULT_INCREMENT_NUMBER = 2;
	private Object myArray[];
	private int size;

	public MyArrayList() {
		myArray = new Object[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
	}
	public MyArrayList(int initialCapacity) {
		myArray = new Object[initialCapacity];
		capacity = initialCapacity;
	}
	public void add( Object obj) {

		if (!checkIndex(size)) {
			increaseCapacity();
		}	
		myArray[size++]=obj;

	}

	public int getSize() {
		return size;
	}
	private boolean checkIndex(int index)
	{if(index<capacity&&index>=0)
	{		return true;}
	return false;
	}
	private void increaseCapacity()
	{
		capacity = capacity*DEFAULT_INCREMENT_NUMBER;
		Object myNewArray[]=Arrays.copyOf(myArray, capacity);
		myArray=myNewArray;
		}

	public void remove(int index) {
		if(!checkIndex(index))
		{
			throw new MyIndexOutOfBoundException(index);
			
		}
		System.arraycopy(myArray, index+1, myArray, index, size);
		size--;
		
	}

	public Object get(int index) {
		if (checkIndex(index)) {

			return myArray[index];	
		}
		else {
			throw new MyIndexOutOfBoundException(index);
		}



	}
}
