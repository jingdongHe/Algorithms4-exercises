package Chapter01.Section01;

public class S1_1_27 {
	private static double binomial(int N,int k,double p) {
		System.out.println(N+" "+k+" "+p);
		if(N==0&&k==0)return 1.0;
		if(N<0||k<0)return 0;
		return p*binomial(N-1, k-1, p)+(1-p)*binomial(N-1, k, p);
	}

	public static void main(String[] args) {
		System.out.println(binomial(10,5,0.25));
	}

}
