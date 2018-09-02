package Chapter03.Section02;

import java.util.Stack;

import Chapter03.Section02.BST.Node;

public class BSTWithoutRec<Key extends Comparable<Key>, Value> extends BST {
	@Override
	public Value get(Comparable key) {
		// TODO Auto-generated method stub
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp == 0)
				return (Value) x.val;
			else if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
		}
		return null;
	}

	@Override
	public void put(Comparable key, Object val) {
		// TODO Auto-generated method stub
		Node x = root, parent = null;
		while (x != null) {
			parent = x;
			int cmp = key.compareTo(x.key);
			if (cmp == 0) {
				x.val = val;
				break;
			} else if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
		}

		// 添加新结点
		if (parent == null) {
			root = new Node(key, val, 1);
			return;
		}
		int cmp = key.compareTo(parent.key);
		if (cmp < 0)
			parent.left = new Node(key, val, 1);
		else if (cmp > 0)
			parent.right = new Node(key, val, 1);

		// 更新结点内部路径的计数
		x = root;
		while (x != null) {
			x.N += 1;
			cmp = key.compareTo(x.key);
			if (cmp == 0) {
				x.val = val;
				x.N -= 1;
				break;
			} else if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
		}
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		Node x = root;
		while (x.left != null)
			x = x.left;
		return (Key) x.key;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		Node x = root;
		while (x.right != null)
			x = x.right;
		return (Key) x.key;
	}

	@Override
	public Key floor(Comparable key) {
		// TODO Auto-generated method stub
		// 这里使用一个技巧，使用树的中序遍历来做
		Stack<Node> stack = new Stack<Node>();
		Node x = root, before = null;
		while (x != null || !stack.empty()) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
			if (!stack.empty()) {
				x = stack.pop();
				if (key.compareTo(x.key) < 0)
					break;
				before = x;
				x = x.right;
			}
		}
		return before != null ? (Key) before.key : null;
	}

	@Override
	public Comparable ceiling(Comparable key) {
		// TODO Auto-generated method stub
		// 这里使用一个技巧，使用树的中序遍历来做
		Stack<Node> stack = new Stack<Node>();
		Node x = root;
		while (x != null || !stack.empty()) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
			if (!stack.empty()) {
				x = stack.pop();
				if (key.compareTo(x.key) < 0)
					break;
				x = x.right;
			}
		}
		return x != null ? (Key) x.key : null;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		Node x = root;
		while (x != null) {
			int t = x.left == null ? 0 : x.left.N;
			if (t > k)
				x = x.left;
			else if (t < k) {
				k = k - t - 1;
				x = x.right;
			} else if (t == k) {
				return (Key) x.key;
			}
		}
		return null;
	}

	@Override
	public int rank(Comparable key) {
		// TODO Auto-generated method stub
		Node x = root;
		int count = 0;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				count += (x.left != null ? x.left.N : 0) + 1;
				x = x.right;
			} else {
				return count + (x.left != null ? x.left.N : 0);
			}
		}
		return 0;
	}
}
