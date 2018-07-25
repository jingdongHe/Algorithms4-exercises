package Chapter01.Section03;

class Steque{
	Node node;
	Node head,tail;
	public Steque(Node node) {
		this.node=node;
		head=node;
		tail=node;
	}
	public void push(Node node) {
		node.next=head;
		head=node;
	}
	public Node pop() {
		Node item=head;
		head=head.next;
		return item;
	}
	public void enqueue(Node node) {
		node.next=tail.next;
		tail.next=node;
		tail=node;
	}
	public void print() {
		head.print();
	}
}

public class S1_3_32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> node1=new Node<Integer>(1);
		Node<Integer> node2=new Node<Integer>(2);
		Node<Integer> node3=new Node<Integer>(3);
		Node<Integer> node9=new Node<Integer>(9);
		
		Steque steque=new Steque(node1);
		steque.push(node2);
		steque.print();
		
		steque.push(node3);
		steque.print();
		
		steque.enqueue(node9);
		steque.print();
		
		steque.pop();
		steque.print();
	}

}
