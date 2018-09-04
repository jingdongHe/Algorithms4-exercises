package Chapter03.Section03;

import java.util.Arrays;

import Chapter03.Section02.BST;

public class S3_3_24 {
	private static void put(RedBlackBST bst, String[] a, int l, int r) {
		int mid = (l + r) / 2;
		if (l <= r) {
			bst.put(a[mid], null);
			put(bst, a, l, mid - 1);
			put(bst, a, mid + 1, r);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ���룬�ں�����У����޺����ӣ�����Ч�����
		// ��ȫ�������޺����ӵĴ���
		String[] a = { "E", "A", "Y", "Q", "U", "T", "I", "O", "N", "B", "C", "D", "F", "G", "H" };
		Arrays.sort(a);

		RedBlackBST<String, String> bst = new RedBlackBST<String, String>();
		put(bst, a, 0, a.length - 1);
		bst.print();
	}

}
