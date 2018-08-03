package Chapter02.Section02;

public class S2_2_28 {
	
	private static void compare(int N) {
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		
		long startTime;
		InplaceMergeSort sort1 = new InplaceMergeSort();
		System.out.println("�Զ�����");
		startTime=System.currentTimeMillis();
		sort1.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
		
		MergeSortByBottom sort2=new MergeSortByBottom();
		System.out.println("�Ե�����");
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
		
//		���������£��Ե����ϱȽϿ죬������10k������ʱ���Զ����±ȽϿ�
//		
//		N:1000
//		�Զ�����
//		3
//		�Ե�����
//		1
//
//		N:10000
//		�Զ�����
//		12
//		�Ե�����
//		28
//
//		N:100000
//		�Զ�����
//		131
//		�Ե�����
//		45
//
//		N:1000000
//		�Զ�����
//		626
//		�Ե�����
//		573
	}

}
