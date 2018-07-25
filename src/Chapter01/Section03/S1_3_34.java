package Chapter01.Section03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

class RandomBag<T> implements Iterable<T>{
	T[] a;
	int N;
	public RandomBag() {
		// TODO Auto-generated constructor stub
		a=(T[]) new Object[3];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		T[] temp=(T[]) new Object[max];
		for(int i=0;i<N;i++)
			temp[i]=a[i];
		a=temp;
	}
	public void add(T item) {
		if(N+1>a.length) resize(a.length*2);
		a[N++]=item;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new BagIterator<T>();
	}
	class BagIterator<T> implements Iterator<T>{
		int i;
		public BagIterator() {
			// TODO Auto-generated constructor stub
			i=0;
			Arrays.sort(a,new Comparator(){

				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					if(o1==null) return 1;
					if(o2==null) return -1;
					return Math.random()>.5 ? -1 : 1;
				}
				
			});
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i<N;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return (T) a[i++];
		}
		
	}
}

public class S1_3_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomBag<Integer> bag=new RandomBag<Integer>();
		bag.add(1);
		bag.add(2);
		bag.add(3);
		bag.add(4);
		bag.add(5);
		for(int b:bag) {
			System.out.print(b+" ");
		}
		System.out.println();
	}

}
