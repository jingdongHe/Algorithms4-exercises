package Chapter02.Section05;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.Comparable;

class Node<Comparable>{
	int index;
	Comparable value;
	public Node(int index, Comparable value) {
		super();
		this.index = index;
		this.value = value;
	}
}
public class S2_5_18 {
	private static void sort(Comparable[] a) {
		Node[] list=new Node[a.length];
		for(int i=0;i<a.length;i++)
			list[i]=new Node(i,a[i]);
		Arrays.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(((Comparable) o1.value).compareTo(o2.value)>0) return 1;
				if(((Comparable) o1.value).compareTo(o2.value)<0) return -1;
				if(o1.index>o2.index) return 1;
				if(o1.index<o2.index) return -1;
				return 0;
			}
		});
		for(int i=0;i<a.length;i++)
			a[i]=(java.lang.Comparable) list[i].value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=100;
		Integer[] a=new Integer[N];
		for(int i=0;i<a.length;i++)
			a[i]=(int) (Math.random()*N);
		sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}

}
