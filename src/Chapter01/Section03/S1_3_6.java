package Chapter01.Section03;


public class S1_3_6 {

	public static void main(String[] args) {
		int[] queueInput= {1,2,3,4,5,6,7,8,9};
		
		Stack<Integer> stack= new Stack(20);
		Queue<Integer> queue=new Queue(20);
		for(int d:queueInput)
			queue.enqueue(d);
		
		while(!queue.isEmpty())
			stack.push(queue.dequeue());
		while(!stack.isEmpty())
			queue.enqueue(stack.pop());
		for(int q:queue) System.out.print(q+" ");

	}

}
