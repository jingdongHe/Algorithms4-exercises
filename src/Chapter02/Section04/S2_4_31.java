package Chapter02.Section04;

class QuickMinPQ<Key extends Comparable<Key>> extends MinPQ {
	public QuickMinPQ(int max) {
		// TODO Auto-generated constructor stub
		pq = (Key[]) new Comparable[max + 1];
	}

	void swim(int k) {
		int n = (int) (Math.log(k) / Math.log(2))+1;
		int left = 1, right = n;
		int compare = 2 * k / (left + right);
		while (left < right) {
			compare = 2 * k / (left + right);
			if (less(compare, k)) {
				left = (left + right) / 2 + 1;
			} else {
				right = (left + right) / 2 - 1;
			}
		}
		// 逆序，需要上移一位
		right++;
		Key value = (Key) pq[k];
		while (k != compare) {
			pq[k] = pq[k / 2];
			k /= 2;
		}
		pq[k / 2] = value;
	}
}

public class S2_4_31 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPQ<Integer> pq = new QuickMinPQ<>(4);

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
