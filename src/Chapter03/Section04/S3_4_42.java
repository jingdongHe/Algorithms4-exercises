package Chapter03.Section04;

public class S3_4_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 1048573;int T=1000000;
		long start;
		start=System.currentTimeMillis();
		LinearProbingHashSTInSec<Integer, Integer> st = new LinearProbingHashSTInSec<>(M);
		for (int i = 0; i < T; i++) 
			st.put((int) (Math.random()*T), i);
		System.out.println("in sec time "+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		LinearProbingHashST<Integer, Integer> st2 = new LinearProbingHashST<>(M);
		for (int i = 0; i < T; i++) 
			st2.put((int) (Math.random()*T), i);
		System.out.println("normal time "+(System.currentTimeMillis()-start));
		
		// 效率类似，但是不稳定，时快时慢
//		in sec time 379
//		normal time 355
//		in sec time 351
//		normal time 404


	}

}
