package Chapter02.Section02;

import java.util.LinkedList;
import java.util.Queue;



public class S2_2_15 {
	
	private static Queue mergeQueue(Queue q1,Queue q2) {
		Queue queue=new LinkedList();
		while(q1.isEmpty()==false&&q2.isEmpty()==false) {
			Comparable item1=(Comparable) q1.element();
			Comparable item2=(Comparable) q2.element();
			if(item1.compareTo(item2)<0)	queue.add(q1.poll());
			else	queue.add(q2.poll());
		}
		while(q1.isEmpty()==false) queue.add(q1.poll());
		while(q2.isEmpty()==false) queue.add(q2.poll());
		return queue;
	}
	
	private static void sort(Queue queue) {
		while(queue.size()>1) {
			Queue q1=(Queue) queue.poll();
			Queue q2=(Queue) queue.poll();
			Queue q=mergeQueue(q1, q2);
			queue.offer(q);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue=new LinkedList();
		
		Queue queue1=new LinkedList();queue1.add(5);
		Queue queue2=new LinkedList();queue2.add(2);
		Queue queue3=new LinkedList();queue3.add(1);
		Queue queue4=new LinkedList();queue4.add(9);
		Queue queue5=new LinkedList();queue5.add(7);
		
		queue.offer(queue1);queue.offer(queue2);queue.offer(queue3);
		queue.offer(queue4);queue.offer(queue5);
		
		System.out.println(queue);
		System.out.println("============");
		sort(queue);
		System.out.println(queue);
		
	}

}
