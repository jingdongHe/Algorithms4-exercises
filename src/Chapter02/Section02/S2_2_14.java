package Chapter02.Section02;

import Chapter01.Section03.Node;

public class S2_2_14 {
	
	public static Node mergeLink(Node link1,Node link2) {
		Node link=new Node(null);
		while(link1!=null&&link2!=null) {
			Comparable node1=(Comparable) link1.node;
			Comparable node2=(Comparable) link2.node;
			if(node1.compareTo(node2)<0) {
				link.add(node1);
				link1=link1.next;
			}else {
				link.add(node2);
				link2=link2.next;
			}
		}
		if(link1!=null) link.add(link1);
		if(link2!=null) link.add(link2);
		return link.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> link1=new Node<Integer>(1);
		link1.add(2);
		link1.add(3);
		link1.add(4);
		
		Node<Integer> link2=new Node<Integer>(3);
		link2.add(6);
		link2.add(7);
		
		link1.print();
		link2.print();
		
		Node link=mergeLink(link1, link2);
		link.print();
	}

}
