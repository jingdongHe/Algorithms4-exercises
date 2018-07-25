package Chapter01.Section03;

class GeneralizedQueue<T> extends Queue{
	public GeneralizedQueue() {
		super(10);
	}
	public void insert(int k,T x) throws Exception {
		if(k<0||k>super.a.length)
			throw new Exception("插入位置不能超过数组大小("+super.a.length+")");
		T[] a=(T[]) new Object[super.a.length+1];
		for(int i=0;i<k;i++) {
			a[i]=(T) super.a[super.head+i];
		}
		a[k]=x;
		for(int i=k;i<super.tail;i++) {
			a[i+1]=(T) super.a[super.head+i];
		}
		tail++;
		super.a=a;
	}
	public T delete(int k) throws Exception {
		if(k<0||k>super.a.length)
			throw new Exception("删除位置不能超过数组大小("+super.a.length+")");
		T temp=(T) super.a[k];
		for(int i=k;i<super.tail;i++)
			super.a[i]=super.a[i+1];
		tail--;
		return temp;
	}
	public void print() {
		for(int i=head;i<tail;i++)
			System.out.print(super.a[i]+" ");
		System.out.println();
	}
}

class GeneralizedLinkQueue<T>{
	class Node{
		Node next;
		T itme;
		public Node(T item) {
			// TODO Auto-generated constructor stub
			next=null;
			this.itme=item;
		}
	}
	Node head,tail;
	int N;
	public void enqueue(T item) {
		Node node=new Node(item);
		if(head==null) head=node;
		if(tail!=null) tail.next=node;
		tail=node;N++;
	}
	public T dequeue() {
		T temp=head.itme;
		head=head.next;N--;
		return temp;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void insert(int k,T x) throws Exception {
		if(k<0||k>N)
			throw new Exception("插入位置不能超过链表大小("+N+")");
		
		Node first=head;
		Node node=new Node(x);
		if(k==0) {
			node.next=first;
			head=node;
		}else {
			while(--k>0) first=first.next;
			node.next=first.next;
			first.next=node;
		}
	}
	public T delete(int k) throws Exception {
		if(k<0||k>N)
			throw new Exception("插入位置不能超过链表大小("+N+")");
		if(k==0) {
			T temp=head.itme;
			head=head.next;
			return temp;
		}
		Node first=head;
		for(int i=0;i<k-1;i++)
			first=first.next;
		T temp=first.next.itme;
		first.next=first.next.next;
		return temp;
	}
	public void print() {
		Node first=head;
		while(first!=null) {
			System.out.print(first.itme+"->");
			first=first.next;
		}
		System.out.println();
	}
}

public class S1_3_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedQueue<Integer> queue=new GeneralizedQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.print();
		
		try {
			queue.insert(3,9);
			queue.print();
			System.out.println(queue.delete(1));
			queue.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		GeneralizedLinkQueue<Integer> linkQueue=new GeneralizedLinkQueue<Integer>();
		linkQueue.enqueue(1);
		linkQueue.print();
		linkQueue.enqueue(2);
		linkQueue.print();
		linkQueue.enqueue(3);
		linkQueue.print();
		linkQueue.enqueue(4);
		linkQueue.print();
		linkQueue.enqueue(5);
		linkQueue.print();
		
		linkQueue.dequeue();
		linkQueue.print();
		
		try {
			linkQueue.insert(4, 9);
			linkQueue.print();
			linkQueue.delete(0);
			linkQueue.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
