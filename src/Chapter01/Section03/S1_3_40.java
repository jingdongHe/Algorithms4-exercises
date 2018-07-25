package Chapter01.Section03;

import Chapter01.Section03.GeneralizedLinkQueue.Node;

class MoveToFront<T>{
	class Node<T>{
		T item;
		Node next;
		public Node(T item) {
			// TODO Auto-generated constructor stub
			this.item=item;
			next=null;
		}
	}
	Node head;
	int N;
	public void add(T item) {
		if(head==null) {
			Node node=new Node(item);
			head=node;
		}
		Node first=head;
		while(first!=null&&first.next!=null) {
			if(first.next.item.equals(item)) {
				Node temp=first.next;
				first.next=first.next.next;
				temp.next=head;
				head=temp;
			}
			first=first.next;
		}
		if(!head.item.equals(item)) {
			Node node=new Node(item);
			node.next=head;
			head=node;
		}
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void print() {
		Node first=head;
		while(first!=null) {
			System.out.print(first.item+"->");
			first=first.next;
		}
		System.out.println();
	}
}
public class S1_3_40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveToFront<Character> front=new MoveToFront<Character>();
		
		String s="abcdad";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			front.add(c);
			front.print();
		}
	}

}
