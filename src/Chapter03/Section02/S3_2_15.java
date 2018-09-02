package Chapter03.Section02;

public class S3_2_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "D", "Q", "A", "J", "T", "M", "S" };

		BST<String, String> bst = new BST<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();

		// floor&&ceiling
		System.out.println("floor " + bst.floor("Q"));
		System.out.println("ceiling " + bst.ceiling("Q"));
		// select&&rank
		System.out.println("select(5) " + bst.select(5));
		System.out.println("rank(J) " + bst.rank("J"));
	}

}
