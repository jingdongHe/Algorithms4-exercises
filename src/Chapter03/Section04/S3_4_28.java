package Chapter03.Section04;

class LinearProbingHashSTInSec<Key, Value> {
	protected int N, M;
	protected Key[] keys;
	protected Value[] vals;

	public LinearProbingHashSTInSec(int M) {
		this.M = M;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}

	protected int hash(Key key) {
//		return 11*N%M;
		return (key.hashCode() & 0x7ffffff) % M;
	}

	public void put(Key key, Value val) {
		int i;
		int k = hash(key);
		for (i = hash(key); keys[i] != null; i = (i + k) % M) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public void print() {
		System.out.println(M);
		System.out.print("[");
		for (int i = 0; i < M; i++)
			System.out.print((keys[i]==null?"":keys[i]) + "(" + (vals[i]==null?"":vals[i]) + "),");
		System.out.print("]\n");
	}
	
	public void delete(Key key) {
		int i=hash(key);int k=hash(key);
		while(keys[i]!=null&&!key.equals(keys[i])) {
			i=(i+k)%M;
		}
		// 不存在于散列表中
		if(keys[i]==null)
			return;
		keys[i]=null;
		vals[i]=null;
		i=(i+k)%M;
		while(keys[i]!=null) {
			Key keyToRedo=keys[i];
			Value valToRedo=vals[i];
			keys[i]=null;
			vals[i]=null;
			N--;
			put(keyToRedo,valToRedo);
			i=(i+k)%M;
		}
		N--;
	}
}

public class S3_4_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 11;
		LinearProbingHashSTInSec<String, Integer> st = new LinearProbingHashSTInSec<>(M);
		for (int i = 0; i < s.length; i++) {
			st.put(s[i], i);
			st.print();
			System.out.println("=============");
		}

	}

}
