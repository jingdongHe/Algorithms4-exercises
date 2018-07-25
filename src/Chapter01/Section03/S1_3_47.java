package Chapter01.Section03;

public class S1_3_47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkStack<Integer> stack1=new LinkStack<Integer>();
		stack1.push(1);stack1.push(2);stack1.push(3);
		
		LinkStack<Integer> stack2=new LinkStack<Integer>();
		stack2.push(10);stack2.push(11);stack2.push(12);
		
		stack1.print();
		stack2.print();
		
		stack1.catenation(stack2);
		stack1.print();
	}

}
