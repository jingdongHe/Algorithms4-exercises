package Chapter01.Section03;
class DoubleNode<T>{
	T node;
	DoubleNode before,after;
	public DoubleNode(T item) {
		// TODO Auto-generated constructor stub
		node=item;
	}
	public void append(DoubleNode node) {
		node.after=this.after;
		node.before=this;
		if(this.after!=null) this.after.before=node;
		this.after=node;
	}
	public void insertBefore(DoubleNode node) {
		node.before=this.before;
		node.after=this;
		if(this.before!=null) this.before.after=node;
		this.before=node;
	}
	public void remove(DoubleNode node) {
		if(node.before!=null) node.before.after=node.after;
		if(node.after!=null) node.after.before=node.before;
		node.before=null;
		node.after=null;
	}
	public void print() {
		DoubleNode head=this;
		do {
			System.out.print(head.node+"->");
			head=head.after;
		}while(head.after!=null);
		System.out.print(head.node);
		System.out.println();
	}
}
public class S1_3_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleNode<Integer> node1=new DoubleNode<Integer>(1);
		DoubleNode<Integer> node2=new DoubleNode<Integer>(2);
		DoubleNode<Integer> node3=new DoubleNode<Integer>(3);
		DoubleNode<Integer> node4=new DoubleNode<Integer>(4);
		node1.before=null;node1.after=node2;
		node2.before=node1;node2.after=node3;
		node3.before=node2;node3.after=node4;
		node4.before=node3;node4.after=null;
		node1.print();
		
		DoubleNode<Integer> node8=new DoubleNode<Integer>(8);
		DoubleNode<Integer> node9=new DoubleNode<Integer>(9);
		
		node2.insertBefore(node8);
		node4.append(node9);
		
		node1.print();
		
		node1.remove(node9);
		node1.print();
		
	}

}
