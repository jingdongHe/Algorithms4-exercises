package Chapter03.Section04;

public class S3_4_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 3;
		SeparateChainingHashSTInSec<String, Integer> st = new SeparateChainingHashSTInSec<>(M);
		for (int i = 0; i < s.length; i++) {
			st.put(s[i], i);
		}
		st.print();
		System.out.println("delete S");
		st.delete("S");
		st.print();
		
		M = 11;
		LinearProbingHashSTInSec<String, Integer> st2 = new LinearProbingHashSTInSec<>(M);
		for (int i = 0; i < s.length; i++) {
			st2.put(s[i], i);
		}
		st2.print();
		System.out.println("delete S");
		st2.delete("S");
		st2.print();
	}

}
