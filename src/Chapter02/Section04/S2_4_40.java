package Chapter02.Section04;

class MaxPQCount<Key extends Comparable<Key>> extends MaxPQ{
	int compareCount=0;
	public MaxPQCount(int max) {
		// TODO Auto-generated constructor stub
		pq = (Key[]) new Comparable[max + 1];
	}
	public MaxPQCount(Key[] a) {
		pq=a.clone();N=a.length-1;
		for(int i=pq.length-1;i>=1;i--) {
			sink(i);
		}
	}
	@Override
	boolean less(int i, int j) {
		// TODO Auto-generated method stub
		compareCount++;
		return super.less(i, j);
	}
	public int count() {
		return compareCount;
	}
}

public class S2_4_40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=0;
		for(int n=1000;n<=1000000000;n*=1000) {
			N=n;
			// 此处偷懒，使用含重复元素的测试样例
			MaxPQCount pq=new MaxPQCount(N);
			for(int i=0;i<n;i++)
				pq.insert(Math.random()*N);
			
			
			while(!pq.isEmpty())
//				System.out.print(pq.delMax()+" ");
				pq.delMax();
			System.out.println("N: "+n+" count: "+pq.count());
		}
		
		
		// 当运行10^9大的堆时，提示内存不足
//		N: 1000 count: 17159
//		N: 1000000 count: 37193199
	}

}
