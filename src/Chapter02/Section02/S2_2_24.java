package Chapter02.Section02;

public class S2_2_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1000000;
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		
		long startTime;
		InplaceMergeSort sort1 = new InplaceMergeSort();
		System.out.println("优化前");
		startTime=System.currentTimeMillis();
		sort1.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
		
		InplaceMergeSortCountCompareIgnoreMerge sort2=new InplaceMergeSortCountCompareIgnoreMerge();
		System.out.println("优化后");
		startTime=System.currentTimeMillis();
		sort2.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
//		经过多次实验，在随机数组中，优化后的效果并不如优化前的效果
//		优化前
//		961
//		优化后
//		1004
//		优化前
//		798
//		优化后
//		1101


	}

}
