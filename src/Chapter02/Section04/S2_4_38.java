package Chapter02.Section04;

public class S2_4_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=1000;
		Integer[] a=new Integer[N];
		for(int i=0;i<N;i++)
			a[i]=i;
		MaxPQ<Integer> pq=new MaxPQ<>(a);
		System.out.println("����");
		pq.show();
		
		for(int i=0;i<N;i++)
			a[i]=N-i;
		pq=new MaxPQ<>(a);
		System.out.println("����");
		pq.show();
		
		for(int i=0;i<N;i++)
			a[i]=0;
		pq=new MaxPQ<>(a);
		System.out.println("ȫ����ͬ");
		pq.show();
		
		for(int i=0;i<N;i++)
			a[i]=i%2;
		pq=new MaxPQ<>(a);
		System.out.println("ֻ��2��ֵ");
		pq.show();
	}

}
