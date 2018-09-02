package Chapter03.Section02;

public class S3_2_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BSTCache<String, String> bst = new BSTCache<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();
		
		System.out.println("the binary tree is ordered in A-A?"+bst.isOrder(bst.root,"A","A"));
		System.out.println("the binary tree is ordered in A-Y?"+bst.isOrder(bst.root,"A","Y"));
	}

}
