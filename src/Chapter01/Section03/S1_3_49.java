package Chapter01.Section03;

class QueueInStack<T>{
	LinkStack<T> in,out;
	int N;
	public QueueInStack() {
		// TODO Auto-generated constructor stub
		in=new LinkStack<T>();
		out=new LinkStack<T>();
	}
	private void inToOut() {
		while(!in.isEmpty()) {
			out.push(in.pop());
		}
	}
	private void outToIn() {
		while(!out.isEmpty()) {
			in.push(out.pop());
		}
	}
	public void enqueue(T item) {
		N++;
		outToIn();
		in.push(item);
	}
	public LinkStack<T>.Node dequeue() {
		N--;
		inToOut();
		return out.pop();
	}
	public int size() {
		return N;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public void print() {
		inToOut();
		out.print();
	}
}

public class S1_3_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueInStack<Integer> queue=new QueueInStack<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(9);
		queue.print();
		
		queue.dequeue();
		queue.print();
	}

}
