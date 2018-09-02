package Chapter03.Section02;

public class S3_2_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BST<String, String> bst = new BSTWithoutRec<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();

		// max&&min
		System.out.println("min " + bst.min());
		System.out.println("max " + bst.max());
		// floor&&ceiling
		System.out.println("floor " + bst.floor("L"));
		System.out.println("ceiling " + bst.ceiling("L"));
		// select&&rank
		System.out.println("select(3) " + bst.select(3));
		System.out.println("rank(N) " + bst.rank("N"));
	}

}
