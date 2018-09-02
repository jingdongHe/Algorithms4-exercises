package Chapter03.Section01;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	protected Key[] keys;
	protected Value[] vals;
	protected int N;

	public BinarySearchST(int capacity) {
		// TODO Auto-generated constructor stub
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public BinarySearchST() {
		// TODO Auto-generated constructor stub
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}

	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	public void put(Key key, Value val) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
		resize();
		assert sorted();
	}
	public void smartPut(Key key, Value val) {
		if (N>1&&key.compareTo(keys[N - 1]) > 0) {
			keys[N] = key;
			vals[N] = val;
			N++;resize();
			return;
		}
		put(key, val);
	}

	private void resize() {
		if (N >= keys.length) {
			Key[] expandKeys = (Key[]) new Comparable[keys.length * 2];
			Value[] expandVals = (Value[]) new Object[vals.length * 2];
			for (int i = 0; i < N; i++) {
				expandKeys[i] = keys[i];
				expandVals[i] = vals[i];
			}
			keys = expandKeys;
			vals = expandVals;
		} else if (N < keys.length / 4) {
			Key[] expandKeys = (Key[]) new Comparable[keys.length / 2];
			Value[] expandVals = (Value[]) new Object[vals.length / 2];
			for (int i = 0; i < N; i++) {
				expandKeys[i] = keys[i];
				expandVals[i] = vals[i];
			}
			keys = expandKeys;
			vals = expandVals;
		}
	}

	public void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(String.format("%s(%s)=>", keys[i], vals[i]));
		}
		System.out.println();
	}

	public void delete(Key key) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			for (int j = i + 1; j < N; j++) {
				keys[j - 1] = keys[j];
				vals[j - 1] = vals[j];
			}
			N--;
		} else {
			System.out.println(key + " not found;");
		}
		assert sorted();
	}

	public int floor(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return hi;
	}
	public int ceiling(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
	public Key min() {
		return N>0?keys[0]:null;
	}
	public Key max() {
		return N>0?keys[N-1]:null;
	}
	public Key select(int k) {
		if(k<0||k>=N)
			return null;
		return keys[k];
	}
	public void deleteMin() {
		delete(min());
	}
	public void deleteMax() {
		delete(max());
	}
	private boolean sorted() {
		System.out.println("进行主键有序检查。。。");
		for(int i=1;i<N;i++)
			if(keys[i].compareTo(keys[i-1])<0)
				return false;
		return true;
	}
}
