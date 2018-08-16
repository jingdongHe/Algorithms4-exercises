package Chapter02.Section04;

public class S2_4_37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time=10;long startTime;
		while(time--!=0) {
			int N=10000;int count=0;
			MaxPQ<Integer> pq = new MaxPQ<>(N);
			// 第一个insert中就已包含了数组缩小的操作
			
			for(int i=0;i<N;i++)
				pq.insert((int) (Math.random()*N));
			startTime=System.currentTimeMillis();
			while(System.currentTimeMillis()-startTime<1) {
				count++;
				pq.delMax();
				pq.insert((int) (Math.random()*N));
			}
			System.out.println(count);
		}
	}
	// 经多次实验，得出与2.4.36近似的结论
//	3
//	80
//	86
//	22
//	58
//	7
//	36
//	373
//	47
//	771


}
