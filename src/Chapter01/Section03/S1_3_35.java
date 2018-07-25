package Chapter01.Section03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

class RandomQueue<T> implements Iterable<T>{
	T[] a;
	int N;
	public RandomQueue() {
		a=(T[]) new Object[2];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public void enqueue(T item) {
		if(N+1>a.length) resize(a.length*2);
		a[N++]=item;
	}
	public T dequeue() {
		if(N-1<a.length/4) resize(a.length/2);
		shuffle();
		return a[--N];
	}
	public T sample() {
		shuffle();
		return a[N-1];
	}
	private void shuffle() {
		Random rand = new Random();
		if(N-2<0) return;
		int shuffle=rand.nextInt(N-1);
		T temp=a[N-1];
		a[N-1]=a[shuffle];
		a[shuffle]=temp;
	}
	private void resize(int max) {
		T[] temp=(T[]) new Object[max];
		for(int i=0;i<N;i++)
			temp[i]=a[i];
		a=temp;
	}
	public void print() {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public void left() {
		for(int i=0;i<N;i++)
			System.out.print(String.format("%4d", a[i]));
		System.out.println();
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ShuffleIterator();
	}
	class ShuffleIterator implements Iterator{
		int i;
		public ShuffleIterator() {
			// TODO Auto-generated constructor stub
			i=0;
			Arrays.sort(a,new Comparator() {

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
		public Object next() {
			// TODO Auto-generated method stub
			return a[i++];
		}
		
	}
}

public class S1_3_35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomQueue<Integer> queue=new RandomQueue<Integer>();
		for(int i=1;i<109;i++)
			queue.enqueue(i);
		
		for(int i=0;i<13;i++)
			System.out.print(String.format("%4d", queue.dequeue()));
		System.out.println();
		for(int i=0;i<13;i++)
			System.out.print(String.format("%4d", queue.dequeue()));
		System.out.println();
		for(int i=0;i<13;i++)
			System.out.print(String.format("%4d", queue.dequeue()));
		System.out.println();
		for(int i=0;i<13;i++)
			System.out.print(String.format("%4d", queue.dequeue()));
		System.out.println();
		queue.left();
		
		for(int q:queue) {
			System.out.print(String.format("%4d", q));
		}
		System.out.println();
	}

}
