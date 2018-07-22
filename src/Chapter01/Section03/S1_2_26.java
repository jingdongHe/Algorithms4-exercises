package Chapter01.Section03;

public class S1_2_26 {
	private static void remove(Node link,String key) {
		Node before,now;
		before=link;
		
		while(before.node.equals(key))	before=before.next;
		now=before.next;
		
		while(now!=null) {
			if(now.node.equals(key))	before.next=now.next;
			else	before=now;
			now=now.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<String> node1=new Node<String>("1");
		Node<String> node2=new Node<String>("2");
		Node<String> node3=new Node<String>("3");
		Node<String> node4=new Node<String>("4");
		node1.next=node2;node2.next=node3;node3.next=node4;
		node1.print();
		
		remove(node1,"3");
		node1.print();
	}

}
