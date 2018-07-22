package Chapter01.Section03;

public class S1_3_12 {

	public static void main(String[] args) {
		Stack<Integer> origin=new Stack<Integer>(10);
		origin.push(5);
		origin.push(6);
		origin.push(7);
		origin.push(8);
		Stack copy=Stack.copy(origin);
		while(!copy.isEmpty()) {
			System.out.println(copy.pop());
		}

	}

}
