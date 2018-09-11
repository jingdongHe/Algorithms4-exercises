package Chapter03.Section04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SeparateChainingHashST<Key, Value> {
	int N, M, K=Integer.MAX_VALUE;
	private int[] primes = { 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191,16381,32749,65521,131071,262139,524287,1048573,2097143,4194301,8338593,16777213,33554393,67108859,134217689,268435399,536870909,1073741789,2147483647 };
	protected HashMap<Key, Value>[] st;

	public SeparateChainingHashST() {
		this(997);
	}

	SeparateChainingHashST(int m, int k) {
		this(m);
		this.K = k;
	}

	public SeparateChainingHashST(int m) {
		M = m;
		st = new HashMap[M];
		for (int i = 0; i < M; i++)
			st[i] = new HashMap<Key, Value>();
	}

	private void resize() {
		int size = 0;
		if (N / M > 2) {
			if (M * 2 > K)
				size = K;
			else
				size = M * 2;
			SeparateChainingHashST<Key, Value> st2 = new SeparateChainingHashST<>(size);
			for (int i = 0; i < M; i++) {
				for (Key key : st[i].keySet()) {
					st2.put(key, st[i].get(key));
				}
			}
			st = st2.st;
			this.M = st2.M;
		}
//		else if (N / M < 2) {
//			if (M / 2 > K)
//				size = K;
//			else
//				size = M / 2;
//			SeparateChainingHashST<Key, Value> st2 = new SeparateChainingHashST<>(size);
//			for (int i = 0; i < M; i++) {
//				for (Key key : st[i].keySet()) {
//					st2.put(key, st[i].get(key));
//				}
//			}
//			st = st2.st;
//			this.M = st2.M;
//		}
	}

	protected int hash(Key key) {
		int t = key.hashCode() & 0x7ffffff;
		int lgM = (int) (Math.log(M) / Math.log(2));
		if (lgM < 26)
			t = t % primes[lgM + 5];
		return t % M;
	}

	public Value get(Key key) {
		return st[hash(key)].get(key);
	}

	public void put(Key key, Value val) {
		int size=st[hash(key)].size();
		st[hash(key)].put(key, val);
		if(st[hash(key)].size()>size) N++;
		resize();
	}

	public void delete(Key key) {
		System.out.println("delete " + key);
		System.out.println(hash(key));
		st[hash(key)].remove(key);
	}

	public Value get(Key key, int hash) {
		return st[hash].get(key);
	}

	public void put(Key key, Value val, int hash) {
		st[hash].put(key, val);
	}

	public void print() {
		for (int i = 0; i < M; i++)
			System.out.println(st[i]);
		System.out.println();
	}
	public Iterable<Key> keys(){
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Key>() {
					int i=0,j=0,searched=0;
					Key[] k;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						if(j==0) {
							Set set=st[j].keySet();
							k=(Key[]) new Object[set.size()];
							while(set.isEmpty())
								set=st[++j].keySet();
							set.toArray(k);
						}
						if(j<M-1&&i-searched>=k.length){
							j++;searched+=k.length;
							Set set=st[j].keySet();
							while(set.isEmpty())
								set=st[++j].keySet();
							k=(Key[]) new Object[set.size()];
							set.toArray(k);
						}
						return i<N;
					}

					@Override
					public Key next() {
						// TODO Auto-generated method stub
						return k[i++-searched];
					}
				};
			}
		};
		
	}
	public double chi() {
		double avgNumber=M*1.0/N;
		double probability=N*1.0/M;
		double sum=0;
		for (int i = 0; i < M; i++)
			sum+=(st[i].size()-probability)*(st[i].size()-probability);
		return avgNumber*sum;
	}
}
