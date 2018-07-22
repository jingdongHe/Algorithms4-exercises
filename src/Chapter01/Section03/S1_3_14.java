package Chapter01.Section03;

class ResizingArrayQueueOfStrings<Item>{
	Item[] a;
	int head,tail;
	public ResizingArrayQueueOfStrings(int size) {
		a=(Item[]) new Object[size];
	}
	private void resize(int max) {
		Item[] temp=(Item[]) new Object[max];
		for(int i=head;i<tail;i++) {
			temp[i-head]=a[i];
		}
		tail=tail-head;head=0;a=temp;
	}
	public int size() {
		return tail-head;
	}
	public void enqueue(Item item) {
		if(tail+1>=a.length) {
			resize(2*size());
		}
		a[tail++]=item;
	}
	public Item dequeue() {
		Item temp=a[head];
		a[head]=null;
		head++;
		if(size()<=a.length/4) {
			resize(a.length/2);
		}
		return temp;
	}
	public void print() {
		for(int i=head;i<tail;i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	@Override
	public String toString() {
		print();
		return String.format("array lenth is : %d ;size is : %d", a.length,size());
	}
}


public class S1_3_14 {

	public static void main(String[] args) {
		ResizingArrayQueueOfStrings<String> queue=new ResizingArrayQueueOfStrings(2);
		queue.enqueue("a");
		System.out.println(queue);
		queue.enqueue("b");
		System.out.println(queue);
		queue.enqueue("c");
		System.out.println(queue);
		queue.enqueue("d");
		System.out.println(queue);
		queue.enqueue("e");
		System.out.println(queue);
		queue.enqueue("f");
		System.out.println(queue);
		queue.enqueue("g");
		System.out.println(queue);
		queue.enqueue("h");
		System.out.println(queue);
		queue.enqueue("i");
		System.out.println(queue);
		
		queue.dequeue();
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);

	}

}
