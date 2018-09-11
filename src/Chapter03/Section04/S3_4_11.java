package Chapter03.Section04;

public class S3_4_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 4;
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>(M);
		for (int i = 0; i < s.length; i++) {
			st.put(s[i], i, 11 * i % M);
		}
		st.print();
	}

}
