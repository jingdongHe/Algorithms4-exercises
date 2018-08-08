package Chapter02.Section03;

import java.util.Arrays;
import java.util.Comparator;

class QuickWithGuard extends QuickWithoutShuffle{
	private int max(Comparable[] a) {
		Comparable max=null;
		int index=-1;
		for(int i=0;i<a.length;i++) {
			if(max==null||max.compareTo(a[i])<0)
				{max=a[i];index=i;}
		}
		return index;
	}
	public void sort(Comparable[] a) {
		exch(a, max(a), a.length-1);
		sort(a,0,a.length-1);
	}
	void sort(Comparable[] a,int lo,int hi) {
		for(Comparable i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		// 右子数组的最左侧元素，可以理解为把j作为左子数组的最右元素（最大值）进行排序
		sort(a,lo,j);
		sort(a,j+1,hi);
	}
	int partition(Comparable[] a,int lo,int hi) {
		int i=lo,j=hi+1;
		Comparable v=a[lo];
		while(true) {
			while(less(a[++i],v)) ;
			while(less(v,a[--j])) ;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
}

public class S2_3_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a=new Integer[30];
		S2_3_16.createList(a);
		
		QuickWithGuard quick=new QuickWithGuard();
		quick.sort(a);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}

}
