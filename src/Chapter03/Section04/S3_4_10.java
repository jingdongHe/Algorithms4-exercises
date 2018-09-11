package Chapter03.Section04;

public class S3_4_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 16;
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>(M);
		for (int i = 0; i < s.length; i++) {
			st.put(s[i], i, i * 11 % M);
		}
		st.print();
		
		// 当M=10，s.length==M，此时，需要进行resize，否则将会无限循环
		M = 10;
		LinearProbingHashST<String, Integer> st2 = new LinearProbingHashST<>(M);
		for (int i = 0; i < s.length; i++) {
			st2.put(s[i], i, i * 11 % M);
		}
		st2.print();
	}

}
