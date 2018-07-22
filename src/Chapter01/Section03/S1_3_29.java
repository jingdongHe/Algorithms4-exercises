package Chapter01.Section03;
class CircleLinkQueue<T>{
	int N;
	Node last;
	public CircleLinkQueue() {
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
		Node temp=last.next;
		last.next=last.next.next;
		return (T) temp.node;
	}
	public boolean isEmpty() {
		return last==null;
	}
	
	public void print() {
		Node head=last.next;
		for(int i=0;i<N;i++) {			
			System.out.print(head.node+",");
			head=head.next;
		}
		System.out.println();
	}
}
public class S1_3_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleLinkQueue<Integer> queue=new CircleLinkQueue<Integer>();
		System.out.println("is empty "+queue.isEmpty());
		
		queue.enqueue(1);
		queue.print();
		queue.enqueue(2);
		queue.print();
		queue.enqueue(3);
		queue.print();
		
		queue.dequeue();
		queue.print();
	}

}
