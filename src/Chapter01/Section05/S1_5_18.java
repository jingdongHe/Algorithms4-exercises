package Chapter01.Section05;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;


class RandomBag<T> implements Iterable<T>{
	T[] a;
	int N;
	Comparator comparator=new Comparator<T>() {

		@Override
		public int compare(T o1, T o2) {
			// TODO Auto-generated method stub
			if(o1==null) return 1;
			if(o2==null) return -1;
			return Math.random()>.5 ? -1 : 1;
		}
	};
	public RandomBag() {
		// TODO Auto-generated constructor stub
		a=(T[]) new Object[10];
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
//			for(int j=0;j<a.length;j++) {
//				System.out.println(a[j]);
//			}
//			System.out.println("========================");
			i=0;
			
			Arrays.sort(a,comparator);
			
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
class Connection{
	public int p;
	public int q;
	public Connection(int p, int q) {
		this.p = p;
		this.q = q;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("p:%d;q:%d", p,q);
	}
	
}

public class S1_5_18 {

	
	static Connection[] generate(int N) {
		RandomBag<Connection> bag=new RandomBag<Connection>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				bag.add(new Connection(i,j));
			}
		}
		
		Connection[] connections=new Connection[N*N];
		int i=0;
		for(Connection c : bag) {
			connections[i++]=c;
		}
		return connections;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=6;
		Connection[] connections=generate(N);
		for(int i=0;i<connections.length;i++) {
			System.out.println(connections[i]);
		}
	}

}
