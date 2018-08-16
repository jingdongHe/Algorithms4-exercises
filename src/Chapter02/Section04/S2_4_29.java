package Chapter02.Section04;

class PQ<Key extends Comparable<Key>>{
	MaxPQ maxPQ;
	MinPQ minPQ;
	int N;
	public PQ() {
		// TODO Auto-generated constructor stub
		maxPQ=new MaxPQ<Key>(10);
		minPQ=new MinPQ<Key>(10);
		N=0;
	}
	public PQ(int max) {
		// TODO Auto-generated constructor stub
		maxPQ=new MaxPQ<Key>(max);
		minPQ=new MinPQ<Key>(max);
		N=0;
	}
	public void insert(Key v) {
		maxPQ.insert(v);
		minPQ.insert(v);
		N++;
	}
	public Key delMax() {
		if(N>0) {
			N--;
			return (Key) maxPQ.delMax();
		}
		return null;
	}
	public Key delMin() {
		if(N>0) {
			N--;
			return (Key) minPQ.delMin();
		}
		return null;
	}
	public Key min() {
		return (Key) minPQ.min();
	}
	public Key max() {
		return (Key) maxPQ.max();
	}
}

public class S2_4_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PQ<Integer> pq=new PQ<>(10);
		
		// 第一个insert中就已包含了数组缩小的操作
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.insert(4);
		pq.insert(5);
		pq.insert(6);
		pq.insert(7);

		System.out.println(pq.delMax());
		System.out.println(pq.delMin());
		System.out.println(pq.delMax());
		System.out.println(pq.delMin());
		pq.insert(10);
		System.out.println(pq.delMax());
		System.out.println(pq.delMin());
		System.out.println(pq.delMax());
		System.out.println(pq.delMin());
	}

}
