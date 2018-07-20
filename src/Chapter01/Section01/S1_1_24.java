package Chapter01.Section01;

public class S1_1_24 {
	private static int gcd(int a,int b) {
		System.out.println(a+" "+b);
		return a == 0 ? b : gcd(b % a, a); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(105,24));
		System.out.println("===================");
		System.out.println(gcd(1111111,1234567));
	}

}
