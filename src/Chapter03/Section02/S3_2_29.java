package Chapter03.Section02;

public class S3_2_29 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BSTCache<String, String> bst = new BSTCache<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();
		
		System.out.println("this is a binary tree?"+bst.isBinaryTree());
	}

}
