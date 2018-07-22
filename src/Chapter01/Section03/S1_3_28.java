package Chapter01.Section03;

public class S1_3_28 {
	private static int max(Node link) {
		if(link==null)return 0;
		int max=max(link.next);
		return (int)link.node>max?(int)link.node:max;
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
