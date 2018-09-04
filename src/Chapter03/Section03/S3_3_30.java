package Chapter03.Section03;

import Chapter03.Section03.RedBlackBST.Node;

class RedBlackBSTWithCache<Key extends Comparable<Key>, Value> extends RedBlackBST {
	Node cache;

	@Override
	protected Node put(Node h, Comparable key, Object val) {
		// TODO Auto-generated method stub
		if (h == null) {
			cache = new Node(key, val, RED);
			return cache;
		}
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp > 0)
			h.right = put(h.right, key, val);
		else {
			cache = h;
			h.val = val;
		}

		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	protected Value get(Node x, Comparable key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else {
			cache = x;
			return (Value) x.val;
		}
	}

	@Override
	public void put(Comparable key, Object val) {
		// TODO Auto-generated method stub
		if (cache != null && key.equals(cache.key)) {
			cache.val = val;
			return;
		}
		super.put(key, val);
	}

	@Override
	public Object get(Comparable key) {
		// TODO Auto-generated method stub
		if (cache != null && key.equals(cache.key))
			return cache.val;
		return super.get(key);
	}
}

public class S3_3_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBSTWithCache<String, String> bst = new RedBlackBSTWithCache<>();
		String[] a = { "E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N" };
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		bst.print();

		System.out.println(bst.cache);
		bst.get("Y");
		System.out.println(bst.cache);
		
		bst.put("Y", null);
		System.out.println(bst.get("Y"));
		;
	}

}
