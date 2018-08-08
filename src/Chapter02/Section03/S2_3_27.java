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
			System.out.print(String.format("小数组内处理排序 %5d", (System.currentTimeMillis()-startTime)));
			
			QuickWithoutSamllList quick2=new QuickWithoutSamllList();
			Insertion insert=new Insertion();
			Integer[] a2=a.clone();
			startTime=System.currentTimeMillis();
			quick2.sort(a2,10);
			insert.sort(a2);
			System.out.print(String.format(" 忽略小数组，最后排序 %5d", (System.currentTimeMillis()-startTime)));
			System.out.println();
		}
		
		// 数据量小于百万时，后插入排序效果较好
//		N:1000
//		小数组内处理排序     2 忽略小数组，最后排序     0
//		N:10000
//		小数组内处理排序    10 忽略小数组，最后排序    21
//		N:100000
//		小数组内处理排序   143 忽略小数组，最后排序    35
//		N:1000000
//		小数组内处理排序   366 忽略小数组，最后排序   413
//		N:10000000
//		小数组内处理排序  5914 忽略小数组，最后排序  6283
	}

}
