package Chapter02.Section02;

public class S2_2_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1000000;
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		InplaceMergeSort sort;
		long startTime;
		System.out.println("插入排序处理较小的数组");
		sort=new InsertMergeSort();
		Integer[] s1=s.clone();
		startTime=System.currentTimeMillis();
		sort.sort(s1);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
//		Merging.print(s1);
		System.out.println("对左、右进行比较，减少merge");
		sort=new InplaceMergeSortCountCompareIgnoreMerge(); 
		Integer[] s2=s.clone();
		startTime=System.currentTimeMillis();
		sort.sort(s2);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
//		Merging.print(s2);
		System.out.println("不进行辅助数组的复制");
		sort=new InplaceMergeSortWithoutCopy(); 
		Comparable[] s3=s.clone();
		startTime=System.currentTimeMillis();
		sort.sort(s3);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
//		Merging.print(s3);
		
		System.out.println("归并排序优化，快速排序");
		sort=new QuickMergeSort();
		startTime=System.currentTimeMillis();
		sort.sort(s);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
		
//		结论如下
//		插入排序处理较小的数组
//		776
//		对左、右进行比较，减少merge
//		953
//		不进行辅助数组的复制
//		632
//		归并排序优化，快速排序
//		696

	}

}
