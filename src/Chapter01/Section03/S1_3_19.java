package Chapter01.Section03;

public class S1_3_19 {

	private static void moveLast(Node link) {
		while(link.next.next!=null) link=link.next;
		link.next=null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> node1=new Node<Integer>(1);
		Node<Integer> node2=new Node<Integer>(2);
		Node<Integer> node3=new Node<Integer>(3);
		Node<Integer> node4=new Node<Integer>(4);
		node1.next=node2;node2.next=node3;node3.next=node4;
		node1.print();
		
		moveLast(node1);
		node1.print();
	}

}
