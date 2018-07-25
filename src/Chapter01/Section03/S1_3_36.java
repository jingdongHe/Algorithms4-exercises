package Chapter01.Section03;

class CircleQueue<T>{
	int N;
	Node last;
	public CircleQueue() {
		// TODO Auto-generated constructor stub
		last=null;
	}
	public void enqueue(T item) {
		Node<T> temp=new Node<T>(item);
		if(isEmpty()) {
			last=temp;
			last.next=last;
		}else {			
			temp.next=last.next;last.next=temp;last=temp;
		}
		N++;
	}
	public T dequeue() {
		N--;
		if(N<0) {
			last=null;
			return null;
		}
		Node temp=last.next;
		last.next=last.next.next;
		return (T) temp.node;
	}
	public boolean isEmpty() {
		return last==null;
	}
	public boolean lastOne() {
		return last.next==last;
	}
	
	public void print() {
		Node head=last.next;
		for(int i=0;i<N;i++) {			
			System.out.print(head.node+",");
			head=head.next;
		}
		System.out.println();
	}
	public void next() {
		last=last.next;
	}
}

public class S1_3_36 {
	
	private static int josephus(int N,int M) {
		CircleQueue<Integer> queue=new CircleQueue<Integer>();
		for(int i=0;i<N;i++) queue.enqueue(i);
		while(!queue.lastOne()) {
			for(int i=0;i<M-1;i++) {
				queue.next();
			}
			System.out.print(queue.dequeue()+" ");
		}
		System.out.println("\n======live======");
		return queue.dequeue();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("live is "+josephus(10, 2));
	}

}
