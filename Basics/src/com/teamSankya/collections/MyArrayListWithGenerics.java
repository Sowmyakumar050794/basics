package com.teamSankya.collections;
import java.util.Arrays;
//import java.util.Collection;
import java.util.Iterator;


public class MyArrayListWithGenerics {
	
	
	public class MyArrayList<E> implements Iterable<E>   {
		private static final int DEFAULT_CAPACITY = 10;
		private int capacity;
		private static final int DEFAULT_LEFT_SHIFT = 1;
		private Object myArray[];
		//private static final Object[] EMPTY_MY_ARRAYLIST = {};
		private int size;
		
		/* public MyArrayList(Collection<? extends E> c) {
		        myArray = c.toArray();
		        if ((size = myArray.length) != 0) {
		            // c.toArray might (incorrectly) not return Object[] (see 6260652)
		            if (myArray.getClass() != Object[].class)
		            	myArray = Arrays.copyOf(myArray, size, Object[].class);
		        } else {
		            // replace with empty array.
		            this.myArray = EMPTY_MY_ARRAYLIST;
		        }
		    }*/


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
			capacity = capacity<<DEFAULT_LEFT_SHIFT;
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
		@Override
		public Iterator<E> iterator() {
			
			return new MyIterator<E>();
		}
		class MyIterator<E> implements Iterator<E>
		{	private int index;
			@Override
			public boolean hasNext() {
				if(index<size)
				{
					return true;
				}
						
				return false;
			}

			@Override
			public E next() {
				if(index>=size)
				{
					throw new MyIndexOutOfBoundException(index);	
				}
				return (E)myArray[index++];
			}
		

	}
	}

}
