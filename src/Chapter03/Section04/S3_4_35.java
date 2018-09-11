package Chapter03.Section04;

public class S3_4_35 {
	private static void intChi() {
		int t = 10000;
		SeparateChainingHashST<Integer, Integer> st = new SeparateChainingHashST<>(11);
		for (int i = 0; i < t; i++)
			st.put((int) Math.random() * t, i);

		System.out.println("chi " + st.chi());
	}

	private static void doubleChi() {
		int t = 10000;
		SeparateChainingHashST<Double, Integer> st = new SeparateChainingHashST<>(11);
		for (int i = 0; i < t; i++)
			st.put((double) Math.random() * t, i);

		System.out.println("chi " + st.chi());
	}

	private static int getRandom(int count) {
		return (int) Math.round(Math.random() * (count));
	}

	private static String string = "abcdefghijklmnopqrstuvwxyz";

	private static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(getRandom(len - 1)));
		}
		return sb.toString();
	}
	private static void strChi() {
		int t = 10000;
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>(11);
		for (int i = 0; i < t; i++)
			st.put(getRandomString(5), i);

		System.out.println("chi " + st.chi());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("int chi");
		intChi();
		System.out.println("double chi");
		doubleChi();
		System.out.println("str chi");
		strChi();
		
//		int chi
//		chi 9.999999999999996
//		double chi
//		chi 5822.540799999839
//		str chi
//		chi 5675.741044626799

	}

}
