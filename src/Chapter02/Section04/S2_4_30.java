package Chapter02.Section04;

class MidPQ<Key extends Comparable<Key>>{
	MaxPQ maxPQ;
	MinPQ minPQ;
	public MidPQ() {
		// TODO Auto-generated constructor stub
		maxPQ=new MaxPQ<Key>(10);
		minPQ=new MinPQ<Key>(10);
	}
	public MidPQ(int max) {
		// TODO Auto-generated constructor stub
		maxPQ=new MaxPQ<Key>(max);
		minPQ=new MinPQ<Key>(max);
	}
	public void insert(Key v) {
		if(maxPQ.isEmpty()) {
			maxPQ.insert(v);
			return;
		}
		if(minPQ.isEmpty()) {
			minPQ.insert(v);
			return;
		}
		if(v.compareTo((Key) maxPQ.max())<0) {
			if(maxPQ.size()>minPQ.size())
				minPQ.insert(maxPQ.delMax());
			maxPQ.insert(v);
		}else if(v.compareTo((Key) minPQ.min())>0) {
			if(minPQ.size()>maxPQ.size())
				maxPQ.insert(minPQ.delMin());
			minPQ.insert(v);
		}else {
			if(maxPQ.size()>minPQ.size())
				minPQ.insert(v);
			else
				maxPQ.insert(v);
		}
	}
	public Key delMid() {
		if(maxPQ.size()<minPQ.size())
		{
			Key value=(Key) minPQ.delMin();
			if(minPQ.size()<maxPQ.size()-1) {
				minPQ.insert(maxPQ.delMax());
			}
			return value;
		}
		else
		{
			Key value=(Key) maxPQ.delMax();
			if(maxPQ.size()<minPQ.size()-1) {
				maxPQ.insert(minPQ.delMin());
			}
			return value;
		}
	}
	public void show() {
		System.out.println("===========");
		minPQ.show();maxPQ.show();
		System.out.println("===========");
	}
}
public class S2_4_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MidPQ<Integer> pq=new MidPQ<>(10);
		
		// 第一个insert中就已包含了数组缩小的操作
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.insert(4);
		pq.insert(5);
		pq.insert(6);
		pq.insert(7);
		pq.show();
		System.out.println(pq.delMid());
		
		pq.insert(9);
		pq.insert(10);
		pq.show();
		System.out.println(pq.delMid());
		
		pq.insert(0);
		pq.insert(1);
		pq.show();
		System.out.println(pq.delMid());
	}

}
