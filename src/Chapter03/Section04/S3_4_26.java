package Chapter03.Section04;

class LinearProbingHashSTDelayedDeletion<Key, Value> extends LinearProbingHashST {
	public LinearProbingHashSTDelayedDeletion(int M) {
		// TODO Auto-generated constructor stub
		super(M);
	}
	@Override
	public void delete(Object key) {
		// TODO Auto-generated method stub
		int i = hash(key);
		while (keys[i] != null && !key.equals(keys[i])) {
			i = (i + 1) % M;
		}
		// 不存在于散列表中
		if (keys[i] == null)
			return;
		vals[i] = null;
		N--;
		if (N > 0 && N <= M / 8)
			resize(M / 2);
	}

	@Override
	protected void resize(int cap) {
		// TODO Auto-generated method stub
		LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
		for (int i = 0; i < M; i++)
			if (keys[i] != null && vals[i] != null)
				t.put((Key) keys[i], (Value) vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
}

public class S3_4_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 5;
		LinearProbingHashSTDelayedDeletion<String, Integer> st = new LinearProbingHashSTDelayedDeletion<>(M);
		for (int i = 0; i < s.length; i++)
			st.put(s[i], i, i * 11 % M);

		st.print();
		System.out.println("delete U");
		st.delete("U");
		st.print();
		System.out.println("delete Q");
		st.delete("Q");
		st.print();
		System.out.println("delete Y");
		st.delete("Y");
		st.print();
		System.out.println("delete A");
		st.delete("A");
		st.print();
		System.out.println("delete E");
		st.delete("E");
		st.print();
		System.out.println("delete S");
		st.delete("S");
		st.print();
	}

}
