package Chapter03.Section04;

public class S3_4_36 {
	private static void maxAndMin(int N) {

		int M = N/100;
		SeparateChainingHashST<Integer, Integer> st = new SeparateChainingHashST<>(M);
		for (int i = 0; i < N; i++)
			st.put((int) (Math.random()*N), i);
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=0;i<M;i++) {
			int size=st.st[i].size();
			if(size>max)max=size;
			if(size<min)min=size;
		}
		System.out.println("N:"+N+"min:"+min+";max:"+max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxAndMin(1000);
		maxAndMin(10000);
		maxAndMin(100000);
		maxAndMin(1000000);
		
//		N:1000min:1;max:4
//		N:10000min:0;max:4
//		N:100000min:0;max:4
//		N:1000000min:0;max:4

	}

}
