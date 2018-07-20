package Chapter01.Section01;

public class S1_1_20 {
	private static double lnN(int N) {
		if(N==0||N==1) return 0;
		return Math.log(N)+lnN(N-1);
	}

	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		System.out.println(lnN(N));
	}

}
