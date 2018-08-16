package Chapter02.Section04;

public class S2_4_41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int N=1000;N<=1000000000;N*=1000) {
			// 此处偷懒，使用含重复元素的测试样例
			for(int j=3;j<=4;j++) {
				MultiwayPQ pq=new MultiwayPQ(N,j);
				for(int i=0;i<N;i++)
					pq.insert(Math.random()*N);
				
				
				while(!pq.isEmpty())
					pq.delMax();
				System.out.println("N: "+N+" multi: "+j+" count: "+pq.count());
			}
		}
		
		// 当运行10^9大的堆时，提示内存不足
		// 对比来说，3向堆的效率比 2向及4向都高
//		N: 1000 multi: 3 count: 5281
//		N: 1000 multi: 4 count: 6256
//		N: 1000000 multi: 3 count: 4953344
//		N: 1000000 multi: 4 count: 6116730
	}

}
