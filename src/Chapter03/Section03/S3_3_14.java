package Chapter03.Section03;

public class S3_3_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String, String> bst = new RedBlackBST<>();
		for (char a = 'A'; a <= 'Z'; a++) {
			bst.put(a + "", null);
		}
		bst.print();
		// 树的高度单调递增，但增速较低
		// 在建树过程中，会不断进行左右转换来维持树的平衡
	}

}
