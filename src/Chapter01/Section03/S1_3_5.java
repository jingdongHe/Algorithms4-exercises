package Chapter01.Section03;


public class S1_3_5 {

	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>(16);
		int N=50;
		while(N>0) {
			stack.push(N%2);
			N/=2;
		}
		for(int d:stack)System.out.print(d);
		System.out.println();

	}

}
