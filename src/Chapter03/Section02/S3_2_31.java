package Chapter03.Section02;

public class S3_2_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BST<String, String> bst = new BST<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();
		
		System.out.println("this binary tree has no duplicates?"+bst.hasNoDuplicates(bst.root));
	}

}
