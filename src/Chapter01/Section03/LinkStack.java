package Chapter01.Section03;

import Chapter01.Section03.LinkQueue.Node;

public class LinkStack<T> {
	class Node{
		Node before;
		T itme;
		public Node(T item) {
			// TODO Auto-generated constructor stub
			before=null;
			this.itme=item;
		}
	}
	Node head;
	int N;
	public LinkStack() {
		// TODO Auto-generated constructor stub
	}
	public LinkStack(LinkStack s){
		// TODO Auto-generated constructor stub
		LinkStack<T> tempStack=new LinkStack<T>();
		while(!s.isEmpty()) {
			Node temp=s.pop();
			tempStack.push(temp);
		}
		while(!tempStack.isEmpty()) {
			Node temp=tempStack.pop();
			s.push(temp);
			this.push(temp);
		}
	}
	public void push(Node node) {
		node.before=head;
		head=node;N++;
	}
	public void push(T item) {
		Node node=new Node(item);
		this.push(node);
	}
	public Node top() {
		//1.3.45
		return head;
	}
	public Node pop() {
		Node temp=head;
		head=head.before;N--;
		return temp;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void print() {
		Node first=head;
		while(first!=null) {
			System.out.print(first.itme+"=>");
			first=first.before;
		}
		System.out.println();
	}
	public void catenation(LinkStack target) {
		//1.3.47
		Node first=target.head;
		while(first.before!=null) {
			first=first.before;
		}
		first.before=this.head;
		this.head=target.head;
	}
}
