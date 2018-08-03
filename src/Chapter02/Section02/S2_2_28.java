package Chapter02.Section02;

public class S2_2_28 {
	
	private static void compare(int N) {
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		
		long startTime;
		InplaceMergeSort sort1 = new InplaceMergeSort();
		System.out.println("自顶向下");
		startTime=System.currentTimeMillis();
		sort1.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
		
		MergeSortByBottom sort2=new MergeSortByBottom();
		System.out.println("自底向上");
		startTime=System.currentTimeMillis();
		sort2.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("N:1000");
		compare(1000);
		System.out.println("\nN:10000");
		compare(10000);
		System.out.println("\nN:100000");
		compare(100000);
		System.out.println("\nN:1000000");
		compare(1000000);
		
//		大多数情况下，自底向上比较快，但是在10k级数据时，自顶向下比较快
//		
//		N:1000
//		自顶向下
//		3
//		自底向上
//		1
//
//		N:10000
//		自顶向下
//		12
//		自底向上
//		28
//
//		N:100000
//		自顶向下
//		131
//		自底向上
//		45
//
//		N:1000000
//		自顶向下
//		626
//		自底向上
//		573
	}

}
