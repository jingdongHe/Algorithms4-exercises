package Chapter03;

public class S3_1_15 {

	private static void ratio(int put,int check) {
		BinarySearchST<Integer, Integer> st=new BinarySearchST<Integer, Integer>(10);
		long startTime=System.currentTimeMillis();
		for(int i=0;i<put;i++)
			st.put(((int)Math.random()*check), 0);
		long putTime=System.currentTimeMillis()-startTime;
		for(int i=0;i<check;i++)
			st.get(((int)Math.random()*check));
		System.out.println(putTime*1.0/(System.currentTimeMillis()-startTime));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("put 1;check 1000;ratio ");
		ratio(1,1000);
		System.out.println("put 1000;check 1000000;ratio ");
		ratio(1000,1000000);
		System.out.println("put 1000000;check 1000000000;ratio ");
		ratio(1000000,1000000000);
//		put 1;check 1000;ratio 
//		0.25
//		put 1000;check 1000000;ratio 
//		0.010416666666666666
//		put 1000000;check 1000000000;ratio 
//		0.001561914282144196
	}

}
