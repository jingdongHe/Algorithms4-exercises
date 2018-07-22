package Chapter01.Section03;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private Item[] a;
	private int head,tail;
	public Queue(int N) {
		a=(Item[]) new Object[N];
	}
	public void enqueue(Item item) {
		a[tail++]=item;
	}
	public Item	dequeue() {
		Item item=a[head];
		a[head]=null;
		head++;
		return item;
	}
	public boolean isEmpty() {
		return head==tail;
	}
	public int size() {
		return tail-head;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public Item next() {
			return dequeue();
		}
		
	}
}
