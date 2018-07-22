package Chapter01.Section03;

public class S1_3_21 {
	private static boolean find(Node link,String key) {
		while(link!=null) {
			if(link.node.equals(key))
				return true;
			link=link.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<String> node1=new Node<String>("1");
		Node<String> node2=new Node<String>("2");
		Node<String> node3=new Node<String>("3");
		Node<String> node4=new Node<String>("4");
		node1.next=node2;node2.next=node3;node3.next=node4;
		node1.print();
		
		System.out.println("find 3 in link "+find(node1,"3"));
		System.out.println("find 5 in link "+find(node1,"5"));
	}

}
