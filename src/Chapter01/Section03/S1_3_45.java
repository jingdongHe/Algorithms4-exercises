package Chapter01.Section03;

public class S1_3_45 {
	private static boolean generated(int[] order) {
		LinkStack<Integer> stack=new LinkStack<Integer>();
		int j=0;
		for(int i=0;i<order.length;i++) {
			stack.push(i);
			while(!stack.isEmpty()&&stack.top().itme==order[j]) {
				stack.pop();j++;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generated(new int[]{1,2,0}));
		System.out.println(generated(new int[]{2,1,0}));
		System.out.println(generated(new int[]{0,1,2}));
		System.out.println(generated(new int[]{2,0,1}));
	}

}
