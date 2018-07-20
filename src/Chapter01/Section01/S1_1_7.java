package Chapter01.Section01;

public class S1_1_7 {
	private static  Double a() {
		double t=9.0;
		while(Math.abs(t-9.0/t)>.001)
			t=(9.0/t+t)/2.0;
		return t;
	}
	private static Integer b() {
		int sum=0;
		for(int i=1;i<1000;i++) {
			for (int j=0;j<i;j++)
				sum++;
		}
		return sum;
	}
	private static Integer c() {
		int sum=0;
		for(int i=1;i<1000;i*=2) {
			for(int j=0;j<10000;j++) {
				sum++;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.printf("%.5f\n",a());
		System.out.println(b());
		System.out.println(c());
	}

}
