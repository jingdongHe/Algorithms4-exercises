package Chapter01.Section03;

class DoubleStackInDeque<T>{
	// AÔÚ×ó£¬BÔÚÓÒ
	int NA,NB;
	Deque<T> queue;
	public DoubleStackInDeque() {
		// TODO Auto-generated constructor stub
		queue=new Deque<T>();
	}
	public void stackAPush(T item) {
		queue.pushLeft(item);NA++;	
	}
	public T stackAPop() {
		NA--;
		return queue.popLeft();
	}
	public int stackASize() {
		return NA;
	}
	public void printA() {
		Chapter01.Section03.Deque.Node first=queue.head;
		for(int i=0;i<stackASize();i++) {
			System.out.print(first.item+"->");
			first=first.next;
		}
		System.out.println();
	}
	public void stackBPush(T item) {
		queue.pushRight(item);NB++;	
	}
	public T stackBPop() {
		NB--;
		return queue.popRight();
	}
	public int stackBSize() {
		return NB;
	}
	public void printB() {
		Chapter01.Section03.Deque.Node first=queue.tail;
		for(int i=0;i<stackBSize();i++) {
			System.out.print(first.item+"->");
			first=first.before;
		}
		System.out.println();
	}
}

public class S1_3_48 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleStackInDeque<Integer> doubleStack=new DoubleStackInDeque<Integer>();
		doubleStack.stackAPush(1);
		doubleStack.stackAPush(2);
		doubleStack.stackAPush(3);
		doubleStack.printA();
		doubleStack.stackAPop();
		doubleStack.printA();
		
		doubleStack.stackBPush(8);
		doubleStack.stackBPush(9);
		doubleStack.stackBPush(10);
		doubleStack.printB();
		doubleStack.stackBPop();
		doubleStack.printB();
	}

}
