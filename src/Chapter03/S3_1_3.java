package Chapter03;

import java.util.Iterator;

class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> implements OrderedST{
	class Node<Key,Value>{
		Key key;
		Value value;
		Node next;
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		public Node() {
			this.key = null;
			this.value = null;
			this.next = null;
		}
	}
	Node head;int N;
	public OrderedSequentialSearchST() {
		this.head = new Node();
		N = 0;
	}

	@Override
	public void put(Comparable key, Object val) {
		// TODO Auto-generated method stub
		Node node=new Node(key, val, null);
		Node first=head;
		while(first.next!=null&&key.compareTo(first.next.key)>=0) {
			first=first.next;
		}
		node.next=first.next;
		first.next=node;N++;
	}

	@Override
	public Object get(Comparable key) {
		// TODO Auto-generated method stub
		Node first=head.next;
		while(first!=null&&key.compareTo(first.key)>0) {
			first=first.next;
		}
		if(key.compareTo(first.key)==0)
			return first.value;
		return null;
	}

	@Override
	public void delete(Comparable key) {
		// TODO Auto-generated method stub
		Node first=head;
		while(first.next!=null&&key.compareTo(first.next.key)>0) {
			first=first.next;
		}
		if(key.compareTo(first.next.key)==0) {
			first.next=first.next.next;N--;
		}
	}

	@Override
	public boolean contains(Comparable key) {
		// TODO Auto-generated method stub
		Node first=head.next;
		while(first!=null&&key.compareTo(first.key)>0) {
			first=first.next;
		}
		if(key.compareTo(first.key)==0)
			return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return N==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}

	@Override
	public Iterable keys() {
		// TODO Auto-generated method stub
		return new Iterable() {

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return new Iterator() {
					Node first=head.next;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return first.next!=null;
					}

					@Override
					public Object next() {
						// TODO Auto-generated method stub
						Object k=first.key;
						first=first.next;
						return k;
					}
				};
			}
		};
	}

	@Override
	public Comparable min() {
		// TODO Auto-generated method stub
		if(N>0) {
			return (Comparable) head.value;
		}
		return null;
	}

	@Override
	public Comparable max() {
		// TODO Auto-generated method stub
		Node first=head;
		while(first.next!=null) {
			first=first.next;
		}
		return (Comparable) first.value;
	}

	@Override
	public Comparable floor(Comparable key) {
		// TODO Auto-generated method stub
		Node result=null;
		Node first=head.next;
		while(first!=null) {
			if(((Comparable) first.key).compareTo(key)<=0)
			{
				result=first;
			}else {
				break;
			}
			first=first.next;
		}
		return result==null?null:((Comparable) result.value);
	}

	@Override
	public Comparable ceiling(Comparable key) {
		// TODO Auto-generated method stub
		Node first=head.next;
		while(first!=null) {
			if(((Comparable) first.key).compareTo(key)>0)	break;
			first=first.next;
		}
		return first==null?null:((Comparable) first.value);
	}

	@Override
	public int rank(Comparable key) {
		// TODO Auto-generated method stub
		Node first=head.next;int count=0;
		while(first!=null) {
			if(((Comparable) first.key).compareTo(key)>0)	break;
			first=first.next;count++;
		}
		return count+1;
	}

	@Override
	public Comparable select(int k) {
		// TODO Auto-generated method stub
		Node first=head.next;
		while(k-->0&&first!=null)	first=first.next;
		return first==null?null:((Comparable) first.value);
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		if(N>0) {
			head.next=head.next.next;N--;
		}
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
		Node first=head;
		int count=N;
		if(count>0) {
			while(count-->0) {
				first=first.next;
			}
			first.next=null;N--;
		}
	}

	@Override
	public int size(Comparable lo, Comparable hi) {
		// TODO Auto-generated method stub
		return rank(hi)-rank(lo)+1;
	}

	@Override
	public Iterable keys(Comparable lo, Comparable hi) {
		// TODO Auto-generated method stub
		return new Iterable() {

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return new Iterator() {
					Node first=head.next;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return first.next!=null;
					}

					@Override
					public Object next() {
						// TODO Auto-generated method stub
						Object k=first.key;
						first=first.next;
						return k;
					}
				};
			}
		};
	}
	
}

public class S3_1_3{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
