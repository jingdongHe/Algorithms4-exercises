package Chapter03.Section02;

public class S3_2_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ·ûºÏ½»»»ÂÉ

		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BST<String, String> bst1 = new BST<String, String>();
		for (int i = 0; i < a.length; i++)
			bst1.put(a[i], null);
		bst1.print();
		System.out.println("=================\n");

		bst1.delete("E");
		bst1.delete("N");
		bst1.print();
		System.out.println("=================");

		BST<String, String> bst2 = new BST<String, String>();
		for (int i = 0; i < a.length; i++)
			bst2.put(a[i], null);
		bst2.print();
		System.out.println("=================\n");
		bst1.delete("N");
		bst1.delete("E");
		bst1.print();
		System.out.println("=================");
	}

}
