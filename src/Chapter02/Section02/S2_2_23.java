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
		System.out.println("�����������С������");
		sort=new InsertMergeSort();
		Integer[] s1=s.clone();
		startTime=System.currentTimeMillis();
		sort.sort(s1);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
//		Merging.print(s1);
		System.out.println("�����ҽ��бȽϣ�����merge");
		sort=new InplaceMergeSortCountCompareIgnoreMerge(); 
		Integer[] s2=s.clone();
		startTime=System.currentTimeMillis();
		sort.sort(s2);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
//		Merging.print(s2);
		System.out.println("�����и�������ĸ���");
		sort=new InplaceMergeSortWithoutCopy(); 
		Comparable[] s3=s.clone();
		startTime=System.currentTimeMillis();
		sort.sort(s3);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
//		Merging.print(s3);
		
		System.out.println("�鲢�����Ż�����������");
		sort=new QuickMergeSort();
		startTime=System.currentTimeMillis();
		sort.sort(s);
		System.out.println(System.currentTimeMillis()-startTime);
//		Merging.print(s);
		
//		��������
//		�����������С������
//		776
//		�����ҽ��бȽϣ�����merge
//		953
//		�����и�������ĸ���
//		632
//		�鲢�����Ż�����������
//		696

	}

}
