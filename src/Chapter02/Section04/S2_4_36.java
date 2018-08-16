package Chapter02.Section04;

public class S2_4_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time=30;long startTime;
		while(time--!=0) {
			int N=10000;
			MaxPQ<Integer> pq = new MaxPQ<>(N);
			startTime=System.currentTimeMillis();
			// 第一个insert中就已包含了数组缩小的操作
			
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
		
		// 经多次实验，可以看出，越往后效率越高，考虑应该是缓存的帮助
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
