package Chapter03;

import java.util.Iterator;

public class SequentialSearchST<Key,Value> {
	private Node first;int N;
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
		
	}
	public Value get(Key key) {
		for(Node x=first;x!=null;x=x.next) {
			if(key.equals(key))
				return x.val;
		}
		return null;
	}
	public void put(Key key,Value val) {
		for(Node x=first;x!=null;x=x.next) {
			if(key.equals(x.key)) {
				x.val=val;return;
			}
		}
		first=new Node(key, val, first);N++;
	}
	public int size() {
		return N;
	}
	public void delete(Key key) {
		if(key.equals(first.key)) {
			first=first.next;return;
		}
		for(Node x=first;x.next!=null;x=x.next) {
			if(key.equals(x.next.key)) {
				first.next=first.next.next;return;
			}
		}
	}
	public void print() {
		for(Node x=first;x!=null;x=x.next) {
			System.out.print(String.format("%s(%s)=>", x.key,x.val));
		}
		System.out.println();
	}
	public boolean contains(Key key) {
		for(Node x=first;x!=null;x=x.next) {
			if(((Comparable) x.key).compareTo(key)==0)
				return true;
		}
		return false;
	}
	public Iterable keys() {
		// TODO Auto-generated method stub
		return new Iterable() {

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return new Iterator() {
					Node x=first;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return x!=null;
					}

					@Override
					public Object next() {
						// TODO Auto-generated method stub
						Object key=x.key;
						x=x.next;
						return key;
					}
				};
			}
		};
	}
}
