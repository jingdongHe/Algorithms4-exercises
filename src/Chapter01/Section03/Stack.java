package Chapter01.Section03;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
	private Item[] a;
	private int N;
	private int pushCount,popCount;
	public Stack(int cap) {
		a=(Item[]) new Object[cap];
	}
	public void push(Item item) {
		pushCount++;
		a[N++]=item;
	}
	public Item pop() {
		popCount++;
		Item item=a[--N];
		a[N]=null;
		return item;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public boolean isFull() {
		return N>=a.length;
	}
	public Item peek() {
		return a[N-1];
	}
	public static Stack copy(Stack that) {
		Iterator iterator=that.iterator();
		
		Stack temp=new Stack(10);
		Stack result=new Stack(10);
		
		while(iterator.hasNext())
			temp.push(iterator.next());
		iterator=temp.iterator();
		while(iterator.hasNext())
			result.push(iterator.next());
		return result;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListInterator(pushCount,popCount);
	}
	private class ListInterator implements Iterator<Item>{
		int push,pop;
		public ListInterator(int pushCount,int popCount) {
			// TODO Auto-generated constructor stub
			this.push=pushCount;
			this.pop=popCount;
		}

		@Override
		public boolean hasNext() {
			if(this.push!=pushCount||this.pop!=popCount) throw new ConcurrentModificationException();
			return !isEmpty();
		}

		@Override
		public Item next() {
			if(this.push!=pushCount||this.pop!=popCount) throw new ConcurrentModificationException();
			this.pop++;
			return pop();
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]!=null?a[i]:" ");
		}
		System.out.println();
		return "stack size:"+a.length+";content size:"+N;
	}
	
}