package Chapter02.Section04;

public class MaxPQ<Key extends Comparable<Key>> {
	Key[] pq;
	int N = 0;

	public MaxPQ() {

	}

	public MaxPQ(int max) {
		pq = (Key[]) new Comparable[max + 1];
	}

	public MaxPQ(Key[] a) {
		pq=a.clone();N=a.length-1;
		for(int i=pq.length-1;i>=1;i--) {
			sink(i);
		}
	}
	
	void resize() {
		// 扩大
		if(N==pq.length-1) {
			Key[] temp=pq;
			pq=(Key[]) new Comparable[temp.length*2];
			for(int i=0;i<temp.length;i++)
				pq[i]=temp[i];
		}
		// 缩小为原来的1/2
		if(N<=(pq.length-1)/4) {
			Key[] temp=pq;
			pq=(Key[]) new Comparable[temp.length/2+1];
			for(int i=0;i<temp.length/2+1;i++)
				pq[i]=temp[i];
		}
	}

	void insert(Key v) {
		pq[0]=pq[0]==null?v:(pq[0].compareTo(v)>0?v:pq[0]);
		pq[++N] = v;
		swim(N);
		resize();
	}

	Key max() {
		return pq[1];
	}
	Key min() {
		return pq[0];
	}

	Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		resize();
		return max;
	}

	public void empty() {
		N=0;
	}
	
	boolean isEmpty() {
		return N == 0;
	}

	int size() {
		return N;
	}

	boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	
	public void show() {
		for(int i=1;i<=N;i++) {
			System.out.print(pq[i]+" ");
		}
		System.out.println();
	}
}
