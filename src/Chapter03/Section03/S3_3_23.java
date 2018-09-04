package Chapter03.Section03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Chapter03.Section02.BST;
import Chapter03.Section03.RedBlackBST.Node;

class RBTreeWithoutBalance<Key extends Comparable<Key>, Value> extends RedBlackBST{
	@Override
	protected Node put(Node h, Comparable key, Object val) {
		// TODO Auto-generated method stub
		if (h == null)
			return new Node(key, val, RED);
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp > 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;

//		if (isRed(h.right) && !isRed(h.left))
//			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
}

public class S3_3_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=16;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(i);
		}
		Collections.shuffle(list);;
		Integer[] a=new Integer[n];
		
		list.toArray(a);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println("\n");
		RedBlackBST<Integer, String> brbst = new RedBlackBST<>();
		RBTreeWithoutBalance<Integer,String> bst=new RBTreeWithoutBalance<Integer,String>();
		for(int i=0;i<n;i++) {
			brbst.put(a[i], null);
			bst.put(a[i], null);
		}
		brbst.print();
		System.out.println("==========");
		bst.print();
		
		// 平均路径长度不好计算，相对于平衡树来说
		// 要略长，但效果不会差太多，有时甚至有相同的效果
//		8 6 0 2 11 12 3 1 5 13 7 14 9 4 10 15 
//
//		11(null),
//		6(11-l(R)),13(11-r(B)),
//		4(6-l(B)),8(6-r(B)),12(13-l(B)),15(13-r(B)),
//		2(4-l(R)),5(4-r(B)),7(8-l(B)),10(8-r(B)),14(15-l(R)),
//		1(2-l(B)),3(2-r(B)),9(10-l(R)),
//		0(1-l(R)),
//		avg compress [42]
//		==========
//		6(null),
//		0(6-l(B)),8(6-r(R)),
//		2(0-r(R)),7(8-l(B)),11(8-r(R)),
//		1(2-l(B)),3(2-r(B)),9(11-l(B)),12(11-r(B)),
//		5(3-r(R)),10(9-r(R)),13(12-r(R)),
//		4(5-l(R)),14(13-r(R)),
//		15(14-r(R)),
//		avg compress [48]
	}

}
