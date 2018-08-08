package Chapter02.Section03;

import Chapter02.Section01.Insertion;

class QuickWithInsert extends Quick{
	void sort(Comparable[] a,int M) {
		sort(a,0,a.length-1,M);
	}
	void sort(Comparable[] a,int lo,int hi,int M) {
		if(hi-lo+1<M)
		{
			Insertion insert=new Insertion();
			insert.sort(a,lo,hi);
			return;
		}
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1,M);
		sort(a,j+1,hi,M);
	}
}

public class S2_3_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickWithInsert quick=new QuickWithInsert();
		long startTime;
		for(int n=1000;n<=1000000;n*=10) {
			Integer[] a=new Integer[n];
			for(int i=0;i<a.length;i++)
				a[i]=(int) (Math.random()*n);
			
			System.out.println("N:"+n);
			for(int m=0;m<=30;m++) {
				System.out.print(String.format("%5d", m));
			}
			System.out.println();
			for(int m=0;m<=30;m++) {
				startTime=System.currentTimeMillis();
				quick.sort(a.clone(),m);
				System.out.print(String.format("%5d", (System.currentTimeMillis()-startTime)));
			}
			System.out.println();
		}
		// M=8、9、10 左右效果较好
//	N:1000
//	    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30
//	    3    0    1    0    1    1    1    1    1    1    1    2    0    1    0    1    0    1    0    1    0    0    0    1    0    1    0    1    0    0    0
//	N:10000
//	    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30
//	   19   20   18   24   16   12   17   10    2    3    2    2    2    1    1    2    2    2    2    3    3    3    2    2    2    2    2    2    2    2    2
//	N:100000
//	    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30
//	   30   31   26   24   25   22   24   23   26   25   24   24   24   27   24   23   24   23   22   24   24   23   22   25   26   23   25   23   23   25   25
//	N:1000000
//	    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30
//	  408  418  389  394  399  394  425  445  401  421  411  388  388  406  397  396  408  392  413  399  423  405  390  416  403  397  397  411  403  389  386
	}

}
