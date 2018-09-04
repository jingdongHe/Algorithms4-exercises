package Chapter03.Section03;

public class S3_3_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String, String> bst = new RedBlackBST<>();
		String[] a = { "E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N" };
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();
		
		System.out.println("is 23-tree? "+bst.is23());
		System.out.println("is balanced? "+bst.isBalanced());
		System.out.println("is binary tree? "+bst.isBinaryTree());
		System.out.println("is order? "+bst.isOrder());
		System.out.println("has no duplicates? "+bst.hasNoDuplicates());
		System.out.println("is RedBlackBST? "+bst.isRedBlackBST());
	}

}
