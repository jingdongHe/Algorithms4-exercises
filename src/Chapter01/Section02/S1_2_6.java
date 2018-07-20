package Chapter01.Section02;

public class S1_2_6 {
	private static boolean circular(String a,String b) {
		return a.length()==b.length()&&(b+b).indexOf(a)!=-1;
	}

	public static void main(String[] args) {
		String a="ACTGACG";
		String b="TGACGAC";
		System.out.println(circular(a, b));

	}

}
