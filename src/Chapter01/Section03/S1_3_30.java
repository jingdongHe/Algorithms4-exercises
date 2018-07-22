package Chapter01.Section03;

public class S1_3_30 {
	private static Node reverse(Node link) {
		Node result=null;
		while(link!=null) {
			Node temp=link;
			link=link.next;
			if(result==null) {
				result=temp;
				result.next=null;
			}else {
				temp.next=result;
				result=temp;
			}
		}
		return result;
	}
	private static Node recurReverse(Node first) {
		if(first==null) return null;
		if(first.next==null) return first;
		Node second=first.next;
		Node rest=recurReverse(second);
		second.next=first;
		first.next=null;
		return rest;
	}
	public static void main(String[] args) {
		Node<Integer> node1=new Node<Integer>(1);
		Node<Integer> node2=new Node<Integer>(2);
		Node<Integer> node3=new Node<Integer>(3);
		Node<Integer> node4=new Node<Integer>(4);
		node1.next=node2;node2.next=node3;node3.next=node4;
		node1.print();
		
		Node<Integer> reverse=reverse(node1);
		reverse.print();
		
//		Node<Integer> reverse=recurReverse(node1);
//		reverse.print();
	}
}
