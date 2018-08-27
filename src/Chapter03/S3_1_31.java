package Chapter03;

public class S3_1_31 {
	private static long capabilityTest() {
		int N=10000;
		BinarySearchST<String, Integer> st=new BinarySearchST(10);
		for(int i=0;i<N;i++)
			st.put(i+"", i);
		long startTime=System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			for(int j=0;j<N;j++)
				st.get(j+"");
		}
		return System.currentTimeMillis()-startTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
			System.out.println(capabilityTest());
	}
	
//	70
//	55
//	42
//	34
//	30
//	29
//	31
//	28
//	31
//	31

}
