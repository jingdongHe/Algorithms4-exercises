package Chapter02.Section01;

public class S2_1_7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10000;
		Integer[] a=new Integer[N];
		for(int i=0;i<N;i++)
			a[i]=N-i;
		
		Insertion insertion=new Insertion();
		long startTime=System.currentTimeMillis();
		insertion.sort(a);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		
		Selection selection=new Selection();
		startTime=System.currentTimeMillis();
		selection.sort(a);
		endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		//�����������У�������������ʱ��ԼΪѡ�������3.5�����ң������������
		//����˳�����У��������򼸺�����ʱ��ѡ���������
	}
}
