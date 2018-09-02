package Chapter03.Section02;

import Chapter03.Section02.BST.Node;

public class BSTCache<Key extends Comparable<Key>, Value> extends BST{
	BST.Node cache;
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
	@Override
	public Value get(Comparable key) {
		// TODO Auto-generated method stub
		if(cache!=null&&cache.key.equals(key))
			return (Value) cache.val;
		cache=getNode(root, (Key) key);
		return (Value) cache.val;
	}
	@Override
	public void put(Comparable key, Object val) {
		// TODO Auto-generated method stub
		if(cache!=null&&cache.key.equals(key)) {
			cache.val=val;
			return;
		}
		super.put(key, val);
	}
}
