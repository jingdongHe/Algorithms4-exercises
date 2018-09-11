package Chapter03.Section04;

import java.util.Iterator;

public class LinearProbingHashST<Key, Value> {

	protected int N, M;
	protected Key[] keys;
	protected Value[] vals;

	public LinearProbingHashST() {
		// TODO Auto-generated constructor stub
		this(16);
	}

	public LinearProbingHashST(int M) {
		this.M = M;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}

	protected int hash(Key key) {
//		return 11*N%M;
		return (key.hashCode() & 0x7ffffff) % M;
	}

	protected void resize(int cap) {
		LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
		for (int i = 0; i < M; i++)
			if (keys[i] != null)
				t.put(keys[i], vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}

	public void put(Key key, Value val) {
		if (N >= M / 2)
			resize(M * 2);
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key))
				return vals[i];
		}
		return null;
	}

	public void put(Key key, Value val, int k) {
		if (N >= M / 2)
			resize(M * 2);
		int i;
		for (i = k; keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public Value get(Key key, int k) {
		for (int i = k; keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key))
				return vals[i];
		}
		return null;
	}

	public void print() {
		System.out.println(M);
		System.out.print("[");
		for (int i = 0; i < M; i++)
			System.out.print((keys[i]==null?"":keys[i]) + "(" + (vals[i]==null?"":vals[i]) + "),");
		System.out.print("]\n");
	}
	
	public void delete(Key key) {
		int i=hash(key);
		while(keys[i]!=null&&!key.equals(keys[i])) {
			i=(i+1)%M;
		}
		// 不存在于散列表中
		if(keys[i]==null)
			return;
		keys[i]=null;
		vals[i]=null;
		i=(i+1)%M;
		while(keys[i]!=null) {
			Key keyToRedo=keys[i];
			Value valToRedo=vals[i];
			keys[i]=null;
			vals[i]=null;
			N--;
			put(keyToRedo,valToRedo);
			i=(i+1)%M;
		}
		N--;
		if(N>0&&N<=M/8) resize(M/2);
	}
	public Iterable<Key> keys() {
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Key>() {
					int i=0;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return i<M;
					}

					@Override
					public Key next() {
						// TODO Auto-generated method stub
						return keys[i++];
					}
				};
			}
		};
		
	}

}
