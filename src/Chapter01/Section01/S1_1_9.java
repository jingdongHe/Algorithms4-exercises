package Chapter01.Section01;

public class S1_1_9 {

	private static String toBinary(int N) {
		String s="";
		for(int n=N;n>0;n/=2) {
			s=(n%2)+s;
		}
		return s;
	}
	
	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		System.out.println(Integer.toBinaryString(N));
		
		System.out.println(toBinary(N));
	}

}
