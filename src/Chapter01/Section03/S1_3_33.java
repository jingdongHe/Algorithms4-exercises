package Chapter01.Section03;

class Deque<T>{
	class Node<T>{
		T item;
		Node before,next;
		public Node(T item) {
			// TODO Auto-generated constructor stub
			this.item=item;
			before=null;next=null;
		}
	}
	Node head,tail;
	int N;
	public Deque() {
		// TODO Auto-generated constructor stub
		head=null;
		tail=null;
		N=0;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size() {
		return N;
	}
	public void pushLeft(T item) {
		Node node=new Node(item);
		node.next=head;
		
		if(head!=null) head.before=node;
		
		head=node;N++;
		if(tail==null) tail=head;
	}
	public void pushRight(T item) {
		Node node=new Node(item);
		node.before=tail;
		
		if(tail!=null) tail.next=node;
		tail=node;N++;
		if(head==null) head=tail;
		
	}
	public T popLeft() {
		Node node=head;
		head=head.next;
		head.before=null;
		N--;
		return (T) node.item;
	}
	public T popRight() {
		Node node=tail;
		tail=tail.before;
		tail.next=null;
		N--;
		return (T) node.item;
	}
	public void print() {
		Node first=head;
		while(first!=null) {
			System.out.print(first.item+" ");
			first=first.next;
		}
		System.out.println();
	}
}

class ResizingArrayDeque<T>{
	T[] a;
	// head指向第一个数据（已压入的）
	// tail只想最后一个数据的后一个位置
	int head,tail;
	public ResizingArrayDeque(int size) {
		a=(T[]) new Object[size];
		head=tail=a.length/2;
	}
	public void resize(int max) {
		T[] temp=(T[]) new Object[max];
		int size=size();
		for(int i=0;i<size;i++) {
			temp[size+i]=a[i+head];
		}
		head=size;
		tail=size*2;
		a=temp;
	}
	public boolean isEmpty(){
		return head==tail;
	}
	public int size() {
		return tail-head;
	}
	public void pushLeft(T item) {
		if(head-1<0) resize(size()*3);
		a[--head]=item;
	}
	public void pushRight(T item) {
		if(tail+1>a.length) resize(size()*3);
		a[tail++]=item;
	}
	public T popLeft() {
		if(size()<a.length/2) resize(size()*3);
		T temp=a[head];
		a[head++]=null;
		return temp;
	}
	public T popRight() {
		if(size()<a.length/2) resize(size()*3);
		T temp=a[tail-1];
		a[--tail]=null;
		return temp;
	}
	public void print() {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
}

public class S1_3_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> deque=new Deque<Integer>();
		
		deque.pushLeft(1);
		deque.pushLeft(2);
		deque.print();
		
		deque.pushLeft(3);
		deque.print();
		
		deque.pushRight(9);
		deque.print();
		
		deque.popRight();
		deque.print();
		
		deque.popLeft();
		deque.print();
		System.out.println("===============");
		ResizingArrayDeque<Integer> qrrayDeque=new ResizingArrayDeque<Integer>(3);
		
		qrrayDeque.pushLeft(1);
		qrrayDeque.print();
		qrrayDeque.pushLeft(2);
		qrrayDeque.print();
		
		qrrayDeque.pushLeft(3);
		qrrayDeque.print();
		
		qrrayDeque.pushRight(9);
		qrrayDeque.print();
		
		qrrayDeque.popRight();
		qrrayDeque.print();
		
		qrrayDeque.popLeft();
		qrrayDeque.print();
	}

}
