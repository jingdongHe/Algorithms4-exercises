package Chapter01.Section01;

public class S1_1_14 {
	private static int lg(int N) {
		int val=1;
		int count=0;
		while(val<=N) {
			val*=2;
			count++;
		}
		return count-1;
	}
	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		System.out.println(lg(N));
	}

}
