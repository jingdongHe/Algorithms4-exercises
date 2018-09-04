package Chapter03.Section03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	protected static final boolean RED = true;
	protected static final boolean BLACK = false;

	Node root;

	class Node {
		Key key;
		Value val;
		Node left, right;
		int N;
		boolean color;

		public Node(Key key, Value val, boolean color) {
			super();
			this.key = key;
			this.val = val;
			this.color = color;
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
						temp.left.val = (Value) (temp.key + "-l(" + (temp.left.color ? "R" : "B") + ")");
						queue.add(temp.left);
					}
					if (temp.right != null) {
						temp.right.val = (Value) (temp.key + "-r(" + (temp.right.color ? "R" : "B") + ")");
						queue.add(temp.right);
					}
				}
				System.out.println();
			}
			System.out.println("avg compress [" + avgCompress + "]");
		}
	}

	protected boolean isRed(Node x) {
		return x == null ? false : x.color == RED;
	}

	public int size(Node x) {
		return x == null ? 0 : x.N;
	}

	public Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.left) + 1;
		return x;
	}

	public Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	protected void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}

	protected Node put(Node h, Key key, Value val) {
		if (h == null)
			return new Node(key, val, RED);
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

	public int height() {
		return height(root, 1);
	}

	private int height(Node x, int level) {
		int leftHeight = level, rightHeight = level;
		if (x.left != null)
			leftHeight = height(x.left, level + (x.left.color ? 0 : 1));
		if (x.right != null)
			rightHeight = height(x.right, level + (x.left.color ? 0 : 1));
		return Math.max(leftHeight, rightHeight);
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
	
	public int getPaht(Node x, Key key,int level) {
		if (x == null)
			return -1;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return getPaht(x.left, key,level+1);
		else if (cmp > 0)
			return getPaht(x.right, key,level+1);
		else
			return level;
	}

	public boolean is23() {
		return is23(root);
	}

	private boolean is23(Node x) {
		boolean result = true;
		if (x.left != null) {
			result = result && is23(x.left);
		}
		if (isRed(x) && (isRed(x.left) || isRed(x.right)))
			result = result && false;
		if (x.right != null && isRed(x.right))
			result = result && false;
		if (x.right != null) {
			result = result && is23(x.right);
		}
		return result;
	}

	public boolean isBalanced() {
		return !(isBalanced(root) == -1);
	}

	private int isBalanced(Node x) {
		if (x == null)
			return 0;
		int left = 0, right = 0;
		if (x.left != null)
			left = isBalanced(x.left);
		if (left == -1)
			return -1;
		if (x.right != null)
			right = isBalanced(x.right);
		if (right == -1)
			return -1;
		if (left == right)
			return left + (isRed(x) ? 0 : 1);
		return -1;
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

	public boolean isOrder() {
		return isOrder(root, min(), max());
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

	public boolean hasNoDuplicates() {
		return hasNoDuplicates(root);
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

	public boolean isRedBlackBST() {
		return is23() && isBalanced() && isBinaryTree() && isOrder() && hasNoDuplicates();
	}

	private Node moveRedLeft(Node h) {
		return null;
	}

	public void deleteMin() {

	}

	private Node deleteMin(Node h) {
		if (h.left == null)
			return null;
		if (!isRed(h.left) && !isRed(h.left.left))
			h = moveRedLeft(h);
		h.left = deleteMin(h.left);
		return balance(h);
	}

	private Node balance(Node h) {
		if (isRed(h.right))
			h = rotateLeft(h);
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
}
