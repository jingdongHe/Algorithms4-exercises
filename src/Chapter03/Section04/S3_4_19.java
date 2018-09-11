package Chapter03.Section04;

public class S3_4_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		int M = 5;
		SeparateChainingHashST<String, Integer> cst = new SeparateChainingHashST<>(M);
		for (int i = 0; i < s.length; i++)
			cst.put(s[i], i);

		cst.print();
		
		for(String key:cst.keys()) {
			System.out.print("key:"+key+" ");
		}
		System.out.println("\n");
		
		LinearProbingHashST<String, Integer> pst = new LinearProbingHashST<>(M);
		for (int i = 0; i < s.length; i++) {
			pst.put(s[i], i);
		}
		pst.print();
		for(String key:pst.keys()) {
			System.out.print("key:"+key+" ");
		}
	}

}
