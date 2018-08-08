package Chapter02.Section03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Quick {
	Comparator compartor=new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return Math.random()<=0.5?1:-1;
		}
	};
	protected void shuffle(Comparable[] a) {
		Arrays.sort(a, compartor);
	}
	public void sort(Comparable[] a) {
		shuffle(a);
		sort(a,0,a.length-1);
	}
	void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	boolean less(Comparable a,Comparable b) {
		return a.compareTo(b)<0;
	}
	void exch(Comparable[] a,int i,int j) {
		Comparable v=a[i];a[i]=a[j];a[j]=v;
	}
	int partition(Comparable[] a,int lo,int hi) {
		int i=lo,j=hi+1;
		Comparable v=a[lo];
		while(true) {
			while(less(a[++i],v)) if(i==hi) break;
			while(less(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
}
