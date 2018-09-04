package Chapter03.Section03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Chapter03.Section02.BST;
import Chapter03.Section03.RedBlackBST.Node;

class RedBlackBSTWithoutColor<Key extends Comparable<Key>, Value> {
	protected static final boolean RED = true;
	protected static final boolean BLACK = false;

	private Node root;

	class Node {
		Key key;
		Value val;
		Node left, right;
		int N;

		public Node(Key key, Value val) {
			super();
			this.key = key;
			this.val = val;
			this.N = 1;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("%s(%s)", this.key, this.val);
		}

		public void print() {
			int avgCompress = 0, level = 0;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this);
			while (!queue.isEmpty()) {
				int size = queue.size();
				avgCompress += level++ * size;
				for (int i = 0; i < size; i++) {
					Node temp = queue.poll();
					System.out.print(temp + ",");
					if (temp.left != null) {
						temp.left.val = (Value) (temp.key + "-l("
								+ (isRed(temp.left) ? "R" : "B") + ")");
						queue.add(temp.left);
					}
					if (temp.right != null) {
						temp.right.val = (Value) (temp.key + "-r("
								+ (isRed(temp.left) ? "R" : "B") + ")");
						queue.add(temp.right);
					}
				}
				System.out.println();
			}
			System.out.println("avg compress [" + avgCompress + "]");
		}
	}

	protected boolean isRed(Node x) {
		if(x==null) return BLACK;
		if(x.left==null) return BLACK;
		if(x.right==null) return BLACK;
		if (x.left.key.compareTo(x.right.key) > 0) {
			return RED;
		}
		return BLACK;
	}

	public int size(Node x) {
		return x == null ? 0 : x.N;
	}

	private void toBlack(Node x) {
		if (x.left != null && x.right != null && x.left.key.compareTo(x.right.key) > 0) {
			Node temp = x.left;
			x.left = x.right;
			x.right = temp;
		}

	}

	private void toRed(Node x) {
		if (x.left != null && x.right != null && x.left.key.compareTo(x.right.key) < 0) {
			Node temp = x.left;
			x.left = x.right;
			x.right = temp;
		}
	}

	public Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		if (isRed(h))
			toRed(x);
		else
			toBlack(x);
		toRed(h);
		x.N = h.N;
		h.N = size(h.left) + size(h.left) + 1;
		return x;
	}

	public Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		if (isRed(h))
			toRed(x);
		else
			toBlack(x);
		toRed(h);
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	protected void flipColors(Node h) {
		toRed(h);
		toBlack(h.left);
		toBlack(h.right);
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
		toBlack(root);
	}

	protected Node put(Node h, Key key, Value val) {
		if (h == null)
			return new Node(key, val);
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp > 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;

		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	public void print() {
		if (root == null)
			return;
		root.print();
	}
}

public class S3_3_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBSTWithoutColor<String, String> bst=new RedBlackBSTWithoutColor<>();
		String[] a= {"E","A","S","Y","Q","U","T","I","O","N"};
		for(int i=0;i<a.length;i++)
			bst.put(a[i], null);
		bst.print();
		
		
		// RedBlackBST
//		S(null),
//		O(S-l(B)),U(S-r(B)),
//		E(O-l(R)),Q(O-r(B)),T(U-l(B)),Y(U-r(B)),
//		A(E-l(B)),N(E-r(B)),
//		I(N-l(R)),
//		avg compress [20]
		
//		E(null),
//		A(E-l(B)),S(E-r(B)),
//		Q(S-l(B)),Y(S-r(B)),
//		I(Q-l(B)),U(Y-l(B)),
//		O(I-r(B)),T(U-l(B)),
//		N(O-l(B)),
//		avg compress [25]
		
//		此题隐约感觉不对，但是确实是能构造出查找树
		
		int n=16;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(i);
		}
		Collections.shuffle(list);;
		Integer[] s=new Integer[n];
		
		list.toArray(s);
		for(int i=0;i<n;i++)
			System.out.print(s[i]+" ");
		System.out.println("\n");
		RedBlackBSTWithoutColor<Integer,String> bst2=new RedBlackBSTWithoutColor<Integer,String>();
		for(int i=0;i<n;i++) {
			bst2.put(s[i], null);
		}
		System.out.println("==========");
		bst2.print();

	}

}
