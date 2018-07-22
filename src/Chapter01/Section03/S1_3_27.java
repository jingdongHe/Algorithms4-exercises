package Chapter01.Section03;

public class S1_3_27 {
	private static int max(Node link) {
		int max=0;
		while(link!=null) {
			if((int)link.node>max) max=(int) link.node;
			link=link.next;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> node1=new Node<Integer>(1);
		Node<Integer> node2=new Node<Integer>(2);
		Node<Integer> node3=new Node<Integer>(3);
		Node<Integer> node4=new Node<Integer>(4);
		node1.next=node2;node2.next=node3;node3.next=node4;
		node1.print();
		
		System.out.println(max(node1));
	}

}
