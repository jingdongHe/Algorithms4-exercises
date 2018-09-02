package Chapter03.Section02;

import java.util.Arrays;

public class S3_2_25 {

	private static void put(BST bst, String[] a, int l, int r) {
		int mid = (l + r) / 2;
		if (l <= r) {
			bst.put(a[mid], null);
			put(bst, a, l, mid - 1);
			put(bst, a, mid + 1, r);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 使用二分查找的比较元素的顺序进行插入，能生成完全二叉树
		String[] a = { "E", "A", "Y", "Q", "U", "T", "I", "O", "N", "B", "C", "D", "F", "G", "H" };
		Arrays.sort(a);

		BST<String, String> bst = new BST<String, String>();
		put(bst, a, 0, a.length - 1);
		bst.print();
	}

}
