package Chapter03.Section04;

public class S3_4_34 {
	
	private static void intCompare() {
		int T=1000000;
		Integer a=3;
		long start=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			a.compareTo(4);
		System.out.println("compare "+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			a.hashCode();
		System.out.println("hash    "+(System.currentTimeMillis()-start));
	}
	private static void doubleCompare() {
		int T=1000000;
		Double a=3.0;
		long start=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			a.compareTo(4.0);
		System.out.println("compare "+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			a.hashCode();
		System.out.println("hash    "+(System.currentTimeMillis()-start));
	}
	private static void strCompare() {
		int T=1000000;
		String a="3.0";
		long start=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			a.compareTo("4.0");
		System.out.println("compare "+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			a.hashCode();
		System.out.println("hash    "+(System.currentTimeMillis()-start));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("int");
		intCompare();
		System.out.println("double");
		doubleCompare();
		System.out.println("String");
		strCompare();
		
		// 对于除string外的2个基本数据类型，hash的效率较高（猜测与比较长度有关）
//		int
//		compare 11
//		hash    7
//		double
//		compare 20
//		hash    7
//		String
//		compare 7
//		hash    13
	}

}
