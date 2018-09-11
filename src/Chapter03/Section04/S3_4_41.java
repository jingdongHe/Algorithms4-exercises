package Chapter03.Section04;

public class S3_4_41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 11;int T=1000000;
		long start;
		start=System.currentTimeMillis();
		SeparateChainingHashSTInSec<Integer, Integer> st = new SeparateChainingHashSTInSec<>(M);
		for (int i = 0; i < T; i++) 
			st.put((int) (Math.random()*T), i);
		System.out.println("in sec time "+(System.currentTimeMillis()-start));
		start=System.currentTimeMillis();
		SeparateChainingHashST<Integer, Integer> st2 = new SeparateChainingHashST<>(M);
		for (int i = 0; i < T; i++) 
			st2.put((int) (Math.random()*T), i);
		System.out.println("normal time "+(System.currentTimeMillis()-start));
		
		
		// 二次探测的效率远高于普通的拉链法
//		in sec time 479
//		normal time 2638
	}

}
