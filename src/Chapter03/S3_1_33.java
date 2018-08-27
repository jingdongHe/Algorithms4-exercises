package Chapter03;

import java.util.Random;

public class S3_1_33 {
	private static void commonTime(int N) {
		Random r = new Random();  
		BinarySearchST<Integer, Integer> st=new BinarySearchST(10);
		for(int i=0;i<N; i++) {  
			st.put((int) (Math.exp(r.nextGaussian())*N), i);
        } 
		for(int i=0;i<N;i++)
			st.get((int) (Math.random()*N));
	}
	private static void cacheTime(int N) {
		Random r = new Random();  
		ArrayST<Integer, Integer> st=new ArrayST();
		for(int i=0;i<N; i++) {  
			st.put((int) (Math.exp(r.nextGaussian())*N), i);
        } 
		for(int i=0;i<N;i++)
			st.get((int) (Math.random()*N));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1000;i<=1000000;i*=10) {
        	System.out.println(i+":");
        	long startTime=System.currentTimeMillis();
        	commonTime(i);
        	System.out.println(System.currentTimeMillis()-startTime);
        	startTime=System.currentTimeMillis();
        	cacheTime(i);
        	System.out.println(System.currentTimeMillis()-startTime);
        	System.out.println("====================");
        }
          
        // 二分查找的性能远远高于缓存的性能
//        	1000:
//        	15
//        	23
//        	====================
//        	10000:
//        	140
//        	335
//        	====================
//        	100000:
//        	18019
//        	68593
         
	}

}
