package Chapter02.Section04;

public class S2_4_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time=30;long startTime;
		while(time--!=0) {
			int N=10000;
			MaxPQ<Integer> pq = new MaxPQ<>(N);
			startTime=System.currentTimeMillis();
			// ��һ��insert�о��Ѱ�����������С�Ĳ���
			
			for(int i=0;i<N;i++)
				pq.insert((int) (Math.random()*N));
			
			for(int i=0;i<N/2;i++) {
				pq.delMax();
			}
			
			for(int i=0;i<N/2;i++)
				pq.insert((int) (Math.random()*N));
			
			for(int i=0;i<N;i++) {
				pq.delMax();
			}
			System.out.println(System.currentTimeMillis()-startTime);
		}
		
		// �����ʵ�飬���Կ�����Խ����Ч��Խ�ߣ�����Ӧ���ǻ���İ���
//		39
//		18
//		15
//		11
//		10
//		10
//		7
//		7
//		7
//		5
//		8
//		8
//		7
//		7
//		8
//		6
//		6
//		6
//		6
//		6
//		5
//		5
//		5
//		5
//		5
//		5
//		6
//		5
//		7
//		6
	}

}
