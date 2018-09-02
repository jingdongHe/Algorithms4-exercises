package Chapter03.Section02;

public class S3_2_43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=1000000;
		BST<Integer, Integer> bst=new BST<>();
		long start;
		
		start=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			bst.put((int) (Math.random()*N), null);
		System.out.println("put "+(System.currentTimeMillis()-start));
		
		start=System.currentTimeMillis();
		for(Integer i:bst.keys())
			bst.get(i);
		System.out.println("get "+(System.currentTimeMillis()-start));
		
		// get的时间要远快于put
//		put 1354
//		get 172
//		ratio 12.7%
//		put 1411
//		get 170
//		ratio 12.04%


	}

}
