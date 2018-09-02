package Chapter03.Section02;

public class S3_2_33 {

	private static boolean rankCheck() {
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BST<String, String> bst = new BST<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		for (int i = 0; i < bst.root.N; i++) {
			System.out.println(i + "<==>" + bst.rank(bst.select(i)));
			if (i != bst.rank(bst.select(i)))
				return false;
		}
		return true;
	}

	private static boolean selectCheck() {
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BST<String, String> bst = new BST<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + "<==>" + bst.select(bst.rank(a[i])));
			if (a[i] != bst.select(bst.rank(a[i])))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("rank check "+rankCheck());
		System.out.println("select check "+selectCheck());
	}

}
