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
		System.out.println("�Ż�ǰ");
		startTime=System.currentTimeMillis();
		sort1.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
		
		InplaceMergeSortCountCompareIgnoreMerge sort2=new InplaceMergeSortCountCompareIgnoreMerge();
		System.out.println("�Ż���");
		startTime=System.currentTimeMillis();
		sort2.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
//		�������ʵ�飬����������У��Ż����Ч���������Ż�ǰ��Ч��
//		�Ż�ǰ
//		961
//		�Ż���
//		1004
//		�Ż�ǰ
//		798
//		�Ż���
//		1101


	}

}
