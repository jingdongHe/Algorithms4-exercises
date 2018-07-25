package Chapter01.Section03;

public class Node<T>{
	T node;
	public Node next;
	public Node(T item) {
		node=item;
		next=null;
	}
	public void print() {
		Node head=this;
		do {
			System.out.print(head.node+"->");
			head=head.next;
		}while(head.next!=null);
		System.out.print(head.node);
		System.out.println();
	}
	public void delete(int k) {
		Node link=this;
		for(int i=0;i<k-2;i++) {
			link=link.next;
		}
		link.next=link.next.next;
	}
	public void removeAfter() {
		this.next=null;
	}
	public void insertAfter(Node node) {
		node.next=this.next;
		this.next=node;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return node.toString();
	}
}