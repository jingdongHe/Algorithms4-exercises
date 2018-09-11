package Chapter03.Section04;

import java.util.HashMap;

class SeparateChainingHashSTInSec<Key, Value> {
	int N, M, K = Integer.MAX_VALUE;
	protected HashMap<Key, Value>[] st1, st2;

	public SeparateChainingHashSTInSec(int m) {
		M = m;
		st1 = new HashMap[M];
		st2 = new HashMap[M];
		for (int i = 0; i < M; i++) {
			st1[i] = new HashMap<Key, Value>();
			st2[i] = new HashMap<Key, Value>();
		}
	}

	private int hash1(Key k) {
		return 11 * (k.hashCode() & 0x7ffffff) % M;
	}

	private int hash2(Key k) {
		return 17 * (k.hashCode() & 0x7ffffff) % M;
	}

	public void put(Key key, Value val) {
		int size1 = st1[hash1(key)].size();
		int size2 = st2[hash2(key)].size();
		if (size2 < size1)
			st2[hash2(key)].put(key, val);
		else
			st1[hash1(key)].put(key, val);
		N++;
	}

	public void print() {
		for (int i = 0; i < M; i++)
			System.out.print(st1[i] + "-->");
		System.out.println();
		for (int i = 0; i < M; i++)
			System.out.print(st2[i] + "-->");
		System.out.println();
	}
	
	public void delete(Key key) {
		if(st1[hash1(key)].containsKey(key)) {
			st1[hash1(key)].remove(key);
		}else if(st2[hash2(key)].containsKey(key)) {
			st2[hash2(key)].remove(key);
		}
	}
}

public class S3_4_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 3;
		SeparateChainingHashSTInSec<String, Integer> st = new SeparateChainingHashSTInSec<>(M);
		for (int i = 0; i < s.length; i++) {
			st.put(s[i], i);
			st.print();
			System.out.println("=============");
		}

	}

}
