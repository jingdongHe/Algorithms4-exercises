package Chapter03.Section02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Chapter03.Section02.BST.Node;

public class BST<Key extends Comparable<Key>, Value> {
	protected Node root;

	protected class Node {
		Key key;
		Value val;
		Node left, right;
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

	public double avgCompares() {
		return avgCompares(root, 0) * 1.0 / root.N + 1;
	}

	public int avgCompares(Node x, int sum) {
		if (x == null)
			return 0;
		return avgCompares(x.left, sum) + avgCompares(x.right, sum) + x.height;
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

	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp > 0)
			return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public Key select(int k) {
		Node x=select(root, k);
		return x==null?null:x.key;
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
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
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
		return x;
	}

	public void delete(Key key) {
		if(key==null) return;
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
		// 中序遍历
		if (cmplo < 0)
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.add(x.key);
		if (cmphi > 0)
			keys(x.right, queue, lo, hi);
	}

	public Key randomKey() {
		int k = (int) (Math.random() * root.N);
		return select(k);
	}

	public boolean isBinaryTree() {
		return count(root) == root.N;
	}

	public boolean isBinaryTree(Node x) {
		return count(x) == x.N;
	}

	private int count(Node x) {
		if (x == null)
			return 0;
		return count(x.left) + count(x.right) + 1;
	}

	public boolean isOrder(Node x, Key MIN, Key MAX) {
		Stack<Node> stack = new Stack<Node>();
		Key min = null, max = null;
		while (x != null || !stack.empty()) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
			min = min == null ? stack.peek().key : min;
			if (!stack.empty()) {
				x = stack.pop();
				if (max != null && x.key.compareTo(max) < 0)
					return false;
				max = x.key;
				x = x.right == null ? null : x.right;
			}
		}
		return min.equals(MIN) && max.equals(MAX);
	}

	public boolean hasNoDuplicates(Node x) {
		// 由于put的时候，已经处理过等值键的问题，不可能再出现等值的键，次方法的作用存疑
		Stack<Node> stack = new Stack<Node>();
		while (x != null || !stack.empty()) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
			if (!stack.empty()) {
				x = stack.pop();
				if (!stack.empty() && x.key.equals(stack.peek().key))
					return false;
				x = x.right == null ? null : x.right;
			}
		}
		return true;
	}

	public boolean isBST(Node x) {
		if (!isBinaryTree(x))
			return false;
		if (!isOrder(x, min(), max()))
			return false;
		if (!hasNoDuplicates(x))
			return false;
		return true;
	}
}
