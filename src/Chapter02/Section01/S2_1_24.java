package Chapter02.Section01;

class InsertSentinel extends Insertion{
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N=a.length;
		Comparable min=a[0];
		int minIndex=0;
		for(int i=1;i<N;i++)
			if(Sort.less(a[i], min)) {
				min=a[i];
				minIndex=i;
			}
		Sort.exch(a, minIndex, 0);
		for(int i=1;i<N;i++) {
			for(int j=i;Sort.less(a[j],a[j-1]);j--)
				Sort.exch(a, j, j-1);
//			Sort.show(a);
		}
	}
}

public class S2_1_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		InsertSentinel insert = new InsertSentinel();
//		int N=1000;
//		Integer[] a=new Integer[N];
//		for(int i=0;i<N;i++)
//			a[i]=(int) (Math.random()*N);
//		insert.sort(a);
//		Sort.show(a);
		int N=10000,T=10;
		SortCompare compare=new SortCompare();
		System.out.println(compare.timeRandomInput(new InsertSentinel(), N, T));
		System.out.println(compare.timeRandomInput(new Insertion(), N, T));
		
		System.out.println("N<10000");
		N=1000;
		System.out.println(compare.timeRandomInput(new InsertSentinel(), N, T));
		System.out.println(compare.timeRandomInput(new Insertion(), N, T));
		
		// ��N��Сʱ�����ܻ����InsertSentinel��Insertion ����ʱ�Ľ������Nȡ�ϴ�ֵʱ���򲻻�����������
		// N=3000����Ϊ�ֽ�
	}

}
