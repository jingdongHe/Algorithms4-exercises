package Chapter02.Section03;

import java.util.Random;

class QuickRandomCut extends Quick{
	public void sort(Comparable[] a) {
		sort(a,0,a.length-1);
	}
	void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int r=(int) (lo+Math.random()*(hi-lo));
		exch(a, lo, r);
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
}

public class S2_3_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quick quick=new Quick();
		QuickRandomCut quick2=new QuickRandomCut();
		long startTime;
		for(int n=1000;n<=1000000;n*=10) {
			Integer[] a=new Integer[n];
			for(int i=0;i<a.length;i++)
				a[i]=(int) (Math.random()*n);
			
			System.out.println("N:"+n);
			startTime=System.currentTimeMillis();
			quick.sort(a.clone());
			System.out.print(String.format("%5d", (System.currentTimeMillis()-startTime)));
			startTime=System.currentTimeMillis();
			quick2.sort(a.clone());
			System.out.print(String.format("%5d", (System.currentTimeMillis()-startTime)));
			System.out.println();
		}
	// 随机切分元素的效率要高的多，事实证明，乱序的效率很低
//	N:1000
//	    7    1
//	N:10000
//	   40   17
//	N:100000
//	  261   32
//	N:1000000
//	 2077  457
	}

}
