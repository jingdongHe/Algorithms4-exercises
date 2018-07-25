package Chapter01.Section03;

public class S1_3_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkStack<Integer> originStack=new LinkStack<Integer>();
		originStack.push(1);
		originStack.push(2);
		originStack.push(3);
		originStack.push(4);
		originStack.print();

		LinkStack<Integer> targetStack=new LinkStack<Integer>(originStack);
		originStack.print();
		targetStack.print();
		
		targetStack.pop();
		targetStack.print();
		originStack.pop();
		originStack.pop();
		originStack.print();
	}

}
