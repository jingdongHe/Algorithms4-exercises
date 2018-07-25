package Chapter01.Section03;

import Chapter01.Section03.GeneralizedLinkQueue.Node;

public class LinkQueue<T> {
	class Node{
		Node next;
		T itme;
		public Node(T item) {
			// TODO Auto-generated constructor stub
			next=null;
			this.itme=item;
		}
	}
	
	int N;
	Node head,tail;
	public LinkQueue() {
		// TODO Auto-generated constructor stub
	}
	public LinkQueue(LinkQueue queue) {
		int size=queue.N;
		for(int i=0;i<size;i++) {
			Node temp=queue.dequeue();
			queue.enqueue(temp);
			this.enqueue(temp);
		}
		
	}
	public void enqueue(Node node) {
		node.next=null;
		if(head==null) head=node;
		if(tail!=null) tail.next=node;
		tail=node;N++;
	}
	public void enqueue(T item) {
		Node node=new Node(item);
		if(head==null) head=node;
		if(tail!=null) tail.next=node;
		tail=node;N++;
	}
	public Node dequeue() {
		Node temp=head;
		head=head.next;N--;
		return temp;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void print() {
		Node first=head;
		while(first!=null) {
			System.out.print(first.itme+"->");
			first=first.next;
		}
		System.out.println();
	}
}
