package Chapter03.Section04;

interface MyHash {
	int hash(Object k);
}

class Cuckoo<Key, Value> {
	int N1, M1;
	int N2, M2;
	protected Key[] keys1, keys2, keys;
	MyHash hash1, hash2, hash;

	public Cuckoo(int cap) {
		// TODO Auto-generated constructor stub
		N1 = N2 = 0;
		M1 = M2 = cap;
		keys1 = (Key[]) new Object[cap];
		keys2 = (Key[]) new Object[cap];
		hash1 = new MyHash() {
			@Override
			public int hash(Object k) {
				// TODO Auto-generated method stub
				return 11 * (k.hashCode() & 0x7ffffff) % M1;
			}
		};
		hash2 = new MyHash() {

			@Override
			public int hash(Object k) {
				// TODO Auto-generated method stub
				return 17 * (k.hashCode() & 0x7ffffff) % M2;
			}
		};
	}

	private void resize1(int cap) {
		Key[] keys = (Key[]) new Object[cap];
		int size=M1;
		M1 = cap;
		for (int i = 0; i < size; i++) {
			if (keys1[i] != null) {
				int j = hash1.hash(keys1[i]);
				while (keys[j] != null)
					j = (j + 1) % M1;
				keys[j] = keys1[i];
			}
		}
		keys1 = keys;
	}

	private void resize2(int cap) {
		Key[] keys = (Key[]) new Object[cap];
		int size=M2;
		M2 = cap;
		for (int i = 0; i < size; i++) {
			if (keys2[i] != null) {
				int j = hash2.hash(keys2[i]);
				while (keys[j] != null)
					j = (j + 1) % M2;
				keys[j] = keys2[i];
			}
		}
		keys2 = keys;
	}

	public void put(Key k, Value val) {

		boolean occ = true;
		int choose = 0;
		Key temp;
		while (true) {
			if (choose % 2 == 1) {
				keys = keys2;
				hash = hash2;
			} else {
				keys = keys1;
				hash = hash1;
			}
			if (keys[hash.hash(k)] == null || keys[hash.hash(k)].equals(k))
				break;
			temp = k;
			k = keys[hash.hash(k)];
			keys[hash.hash(k)] = temp;
			choose++;
		}
		keys[hash.hash(k)] = k;
		if (choose % 2 == 1) {
			N2++;
			if (N2 > M2 / 2)
				resize2(M2 * 2);
		} else {
			N1++;
			if (N1 > M1 / 2)
				resize1(M1 * 2);
		}
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < M1; i++)
			System.out.print((keys1[i] == null ? "" : keys1[i]) + ",");
		System.out.print("]\n");
		System.out.print("[");
		for (int i = 0; i < M2; i++)
			System.out.print((keys2[i] == null ? "" : keys2[i]) + ",");
		System.out.print("]\n");
		System.out.println("===================");
	}
}

public class S3_4_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuckoo<String, Integer> cuckoo = new Cuckoo<String, Integer>(13);
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		for (int i = 0; i < s.length; i++) {
			cuckoo.put(s[i], i);
			System.out.println(s[i]);
			cuckoo.print();
		}
		cuckoo.print();
	}

}
