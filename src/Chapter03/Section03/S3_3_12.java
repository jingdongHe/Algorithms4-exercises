package Chapter03.Section03;

public class S3_3_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��׼����������ͼ3.3.24
		String[] a = { "E", "A", "R", "C", "H", "X", "M", "P", "L" };
		RedBlackBST<String, String> bst = new RedBlackBST<>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();
		System.out.println("===========");
		bst.put("P", null);
		bst.print();
	}

}
