package Chapter01.Section03;

public class S1_3_41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<Integer> originQueue=new LinkQueue<Integer>();
		originQueue.enqueue(1);
		originQueue.enqueue(2);
		originQueue.enqueue(3);
		originQueue.enqueue(4);
		originQueue.print();
		
		LinkQueue<Integer> targetQueue=new LinkQueue<Integer>(originQueue);
		originQueue.print();
		targetQueue.print();
		
		originQueue.dequeue();
		originQueue.print();
		targetQueue.enqueue(10);
		targetQueue.print();
	}

}
