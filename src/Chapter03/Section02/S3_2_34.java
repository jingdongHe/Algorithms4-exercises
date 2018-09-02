package Chapter03.Section02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Chapter03.Section02.BST.Node;

class ThreadedST<Key extends Comparable<Key>, Value> {
	protected Node root;

	protected class Node {
		Key key;
		Value val;
		Node left, right;
		Node pred, succ;
		int N;
		int height;

		public Node(Key key, Value val, int n) {
			this.key = key;
			this.val = val;
			N = n;
			height = 1;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("%s(%s)", this.key, this.val);
		}

		public void print() {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Node temp = queue.poll();
					System.out.print(temp + ",");
					if (temp.left != null) {
						temp.left.val = (Value) (temp.key + "-l");
						queue.add(temp.left);
					}
					if (temp.right != null) {
						temp.right.val = (Value) (temp.key + "-r");
						queue.add(temp.right);
					}
				}
				System.out.println();
			}
		}
	}

	public int size() {
		return size(root);
	}

	protected int size(Node x) {
		if (x == null)
			return 0;
		return x.N;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	protected Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	protected Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		x.height = height(x);
		x.pred = x.left==null?null:max(x.left);
		x.succ = x.right==null?null:min(x.right);
		return x;

	}

	public void print() {
		if (root == null)
			return;
		root.print();
	}

	public int rootHeight() {
		// 获取树的高度，以添加变量的方法
		return root.height;
	}

	protected int height(Node x) {
		int max = 0;
		if (x.left != null)
			max = max > x.left.height ? max : x.left.height;
		if (x.right != null)
			max = max > x.right.height ? max : x.right.height;
		return max + 1;
	}

	public int height() {
		return height(root, 1);
	}

	private int height(Node x, int level) {
		int leftHeight = level, rightHeight = level;
		if (x.left != null)
			leftHeight = height(x.left, level + 1);
		if (x.right != null)
			rightHeight = height(x.right, level + 1);
		return Math.max(leftHeight, rightHeight);
	}

	public Key min() {
		return min(root).key;
	}

	protected Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	public Key max() {
		return max(root).key;
	}

	protected Node max(Node x) {
		if (x.right == null)
			return x;
		return max(x.right);
	}

	Node getNode(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo((Key) x.key);
		if (cmp < 0)
			return getNode(x.left, key);
		else if (cmp > 0)
			return getNode(x.right, key);
		else
			return x;
	}

	public Key select(int k) {
		return select(root, k).key;
	}

	private Node select(Node x, int k) {
		if (x == null)
			return null;
		int t = size(x.left);
		if (t > k)
			return select(x.left, k);
		else if (t < k)
			return select(x.right, k - t - 1);
		else
			return x;
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if (cmp > 0)
			return rank(key, x.right) + size(x.left) + 1;
		else
			return size(x.left);
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		x.pred = x.left==null?null:max(x.left);
		x.succ = x.right==null?null:min(x.right);
		return x;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		x.pred = x.left==null?null:max(x.left);
		x.succ = x.right==null?null:min(x.right);
		return x;
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		x.pred = x.left==null?null:max(x.left);
		x.succ = x.right==null?null:min(x.right);
		return x;
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new LinkedList<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0)
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.add(x.key);
		if (cmphi > 0)
			keys(x.right, queue, lo, hi);
	}

	public Key next(Key key) {
		Node x = getNode(root, key);
		return x.succ==null?null:x.succ.key;
	}

	public Key prev(Key key) {
		Node x = getNode(root, key);
		return x.pred==null?null:x.pred.key;
	}
}

public class S3_2_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		ThreadedST<String, String> tst = new ThreadedST<String, String>();
		for (int i = 0; i < a.length; i++)
			tst.put(a[i], null);

		System.out.println("S next "+tst.next("S"));
		System.out.println("S prev "+tst.prev("S"));
		
		tst.deleteMin();
		tst.print();
		System.out.println("E next "+tst.next("E"));
		System.out.println("E prev "+tst.prev("E"));
	}

}
