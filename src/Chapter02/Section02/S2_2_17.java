package Chapter02.Section02;

import java.util.LinkedList;
import java.util.Queue;

import Chapter01.Section03.Node;

public class S2_2_17 {
	
	private static boolean isSort(Node link) {
		Node first=link.next;
		while(first.next!=null) {
			Comparable node1=(Comparable) first.node;
			Comparable node2=(Comparable) first.next.node;
			if(node1.compareTo(node2)>0) return false;
			first=first.next;
		}
		return true;
	}
	
	private static void print(Node link) {
		Node first=link;
		while(first!=null) {
			System.out.print(first.node+"->");
			first=first.next;
		}
		System.out.println();
	}
	
	private static Node sort(Node link) {
		Node origin=new Node(null);
		origin.next=link;
		Node temp;
		Node before=null,after=null;
		Node first=null,sec=null;
		Node tail = null;
		while(isSort(origin)==false) {
			tail=origin.next;
			first=tail;
			while(tail.next!=null&&((Comparable) tail.node).compareTo(tail.next.node)<0)	tail=tail.next;
			temp=tail;tail=tail.next;temp.next=null;sec=tail;
			
			while(tail.next!=null&&((Comparable) tail.node).compareTo(tail.next.node)<0)	tail=tail.next;
			origin.next=tail.next;tail.next=null;
			
			Node merge=merge(first,sec);
//			print(merge);
			origin.add(merge);
		}
		return origin.next;
	}
	public static Node merge(Node link1,Node link2) {
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
		int N=5;
		Node<Integer> link=new Node<Integer>(N);
		for(int i=0;i<N;i++) {
			link.add((int) (Math.random()*N));
		}
		
		link.print();
		
		Node s=sort(link);
		print(s);
	}

}
