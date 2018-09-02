package Chapter03.Section02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Chapter03.Section02.BST.Node;

class BSTWithNoRepcKeys<Key extends Comparable<Key>, Value> extends BST{
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	@Override
	public Iterable<Key> keys(Comparable lo, Comparable hi) {
		// TODO Auto-generated method stub
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Key>() {
					Node x=root;
					Key result=null;
					Stack<Node> stack = new Stack<Node>();
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return x != null || !stack.empty();
					}

					@Override
					public Key next() {
						// TODO Auto-generated method stub
						while (x != null) {
							stack.push(x);
							x = x.left;
						}
						if (!stack.empty()) {
							x = stack.pop();
							result=(Key) x.key;
							x = x.right == null ? null : x.right;
						}
						return result;
					}
				};
			}
		};
	}
}

public class S3_2_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };

		BSTWithNoRepcKeys<String, String> bst = new BSTWithNoRepcKeys<String, String>();
		for (int i = 0; i < a.length; i++)
			bst.put(a[i], null);
		
		for(String b:bst.keys()) {
			System.out.println(b);
		}
	}

}
