package Chapter02.Section04;

class MultiwayPQ<Key extends Comparable<Key>> extends MaxPQ{
	int n=2;
	int compareCount=0;
	public MultiwayPQ(int max,int n) {
		// TODO Auto-generated constructor stub
		pq = (Key[]) new Comparable[max + 1];
		this.n=n;
	}
	void swim(int k) {
		while (k > 1 && less(k / n, k)) {
			exch(k / n, k);
			k = k / n;
		}
	}

	void sink(int k) {
		while (n * k <= N) {
			int j = n * k;
			int maxIndex=j;
			for(int i=1;i<n;i++) {
				if(j+i<N&&less(maxIndex,j+i))
					maxIndex=j+i;
					
			}
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	@Override
	boolean less(int i, int j) {
		// TODO Auto-generated method stub
		compareCount++;
		return super.less(i, j);
	}
	int count() {
		return compareCount;
	}
}

public class S2_4_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiwayPQ<Integer> pq=new MultiwayPQ<Integer>(4,2);
		
		// 第一个insert中就已包含了数组缩小的操作
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.insert(4);
		pq.insert(5);
		pq.insert(6);
		pq.insert(7);
		
		pq.show();
	}

}
