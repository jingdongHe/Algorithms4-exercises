package Chapter01.Section03;

public class S1_3_15 {

	public static void main(String[] args) {
		int k=2;
		Queue<String> queue=new Queue<String>(10);
		queue.enqueue("first");
		queue.enqueue("second");
		queue.enqueue("third");
		queue.enqueue("fourth");
		queue.enqueue("fifth");
		
		int size=queue.size();
		for(int i=0;i<size-k;i++) {
			queue.dequeue();
		}
		System.out.println(queue.dequeue());

	}

}
