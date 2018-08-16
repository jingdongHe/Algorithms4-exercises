package Chapter02.Section04;

class MaxPQNoExch<Key extends Comparable<Key>> extends MaxPQ {
	public MaxPQNoExch(int max) {
		// TODO Auto-generated constructor stub
		pq = (Key[]) new Comparable[max + 1];
	}
	private void change(int i, int j) {
		// j 向 i 移动
		pq[i] = pq[j];
	}

	void swim(int k) {
		Key value = (Key) pq[k];
		while (k > 1 && pq[k / 2].compareTo(value) < 0) {
			change(k, k / 2);
			k = k / 2;
		}
		pq[k] = value;
	}

	void sink(int k) {
		Key value = (Key) pq[k];
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			change(j, k);
			k = j;
		}
		pq[k] = value;
	}
}

public class S2_4_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPQNoExch<Integer> pq=new MaxPQNoExch<>(4);
		
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
