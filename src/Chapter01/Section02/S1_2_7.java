package Chapter01.Section02;

public class S1_2_7 {
	private static String mystery(String s) {
		//µ¹Ðò
		int N=s.length();
		if(N<=1)return s;
		String a=s.substring(0, N/2);
		String b=s.substring(N/2,N);
		return mystery(b)+mystery(a);
	}

	public static void main(String[] args) {
		String s="123456789";
		System.out.println(s+"\n"+mystery(s));

	}

}
