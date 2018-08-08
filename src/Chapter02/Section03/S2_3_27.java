package Chapter02.Section03;

import Chapter02.Section01.Insertion;

class QuickWithoutSamllList extends Quick{
	void sort(Comparable[] a,int M) {
		sort(a,0,a.length-1,M);
	}
	void sort(Comparable[] a,int lo,int hi,int M) {
		if(hi-lo+1<M)
		{
			return;
		}
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1,M);
		sort(a,j+1,hi,M);
	}
}
public class S2_3_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startTime;
		for(int n=1000;n<=10000000;n*=10) {
			Integer[] a=new Integer[n];
			for(int i=0;i<a.length;i++)
				a[i]=(int) (Math.random()*n);
			
			System.out.println("N:"+n);
			
			
			QuickWithInsert quick=new QuickWithInsert();
			startTime=System.currentTimeMillis();
			quick.sort(a.clone(),10);
			System.out.print(String.format("С�����ڴ������� %5d", (System.currentTimeMillis()-startTime)));
			
			QuickWithoutSamllList quick2=new QuickWithoutSamllList();
			Insertion insert=new Insertion();
			Integer[] a2=a.clone();
			startTime=System.currentTimeMillis();
			quick2.sort(a2,10);
			insert.sort(a2);
			System.out.print(String.format(" ����С���飬������� %5d", (System.currentTimeMillis()-startTime)));
			System.out.println();
		}
		
		// ������С�ڰ���ʱ�����������Ч���Ϻ�
//		N:1000
//		С�����ڴ�������     2 ����С���飬�������     0
//		N:10000
//		С�����ڴ�������    10 ����С���飬�������    21
//		N:100000
//		С�����ڴ�������   143 ����С���飬�������    35
//		N:1000000
//		С�����ڴ�������   366 ����С���飬�������   413
//		N:10000000
//		С�����ڴ�������  5914 ����С���飬�������  6283
	}

}
