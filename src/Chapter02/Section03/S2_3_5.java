package Chapter02.Section03;

import java.util.Arrays;
import java.util.Collections;

class QuickCompareTow extends Quick{
	@Override
	void sort(Comparable[] a,int lo,int hi) {
		for(Comparable i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		return;
	}
	int partition(Comparable[] a,int lo,int hi) {
		int i=lo,j=hi+1;
		Comparable v=a[lo];
		Integer max = (int) Collections.max(Arrays.asList(a));
		while(true) {
			while(a[++i].compareTo(v)<0||(v!=max&&a[i].compareTo(v)==0)) if(i==hi) break;
			while(v.compareTo(a[--j])<0||(v==max&&a[j].compareTo(v)==0)) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
}

public class S2_3_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 实际上，该题只需要进行快排的第1次即可
		// 若第一个数为较大值，与较大值相等的往后排
		// 若第一个数为较小值，与较小值相等的往前排
		Quick quick=new QuickCompareTow();
		Integer[] a1=new Integer[10];
		for(int i=0;i<a1.length;i++) a1[i]=Math.random()<0.5?1:0;
		
		quick.sort(a1);
		
		System.out.println("===================");
		for(Integer a:a1)
			System.out.print(a+" ");
		
	}

}
