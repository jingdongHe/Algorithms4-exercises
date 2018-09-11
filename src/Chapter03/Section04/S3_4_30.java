package Chapter03.Section04;

public class S3_4_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 5;
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>(M);
		for (int i = 0; i < s.length; i++)
			st.put(s[i], i);

		st.print();
		System.out.println(st.N);
		// 散列函数产生的随机值是否满足假设
		System.out.println("chi is " + st.chi());
	}

}
