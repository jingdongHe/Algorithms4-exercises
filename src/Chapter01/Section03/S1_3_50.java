package Chapter01.Section03;

public class S1_3_50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack=new Stack<Integer>(10);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		for(Integer s:stack) {
			System.out.println(s);
//			stack.pop();
		}
	}

}
