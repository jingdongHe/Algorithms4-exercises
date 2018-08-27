package Chapter03;

public class S3_1_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = 0,end=0;
		System.gc();
		Runtime.getRuntime().freeMemory();
		
		System.gc();
		start = Runtime.getRuntime().freeMemory();
		SequentialSearchST<Integer,String> st2=new SequentialSearchST<Integer,String>();
		
		for(int i=0;i<1000;i++) {
			st2.put((int)(Math.random()*1000), "");
		}
		System.gc();
		end = Runtime.getRuntime().freeMemory();
		System.out.println("对象内存:" + (start - end)/1000.0 + " KB");
		
		System.gc();
		start = Runtime.getRuntime().freeMemory();
		BinarySearchST<Integer,String> st1=new BinarySearchST<Integer,String>(10);
		
		for(int i=0;i<1000;i++) {
			st1.put((int)(Math.random()*1000), "");
		}
		System.gc();
		end = Runtime.getRuntime().freeMemory();
		System.out.println("对象内存:" + (start - end)/1000.0 + " KB");
		
//		对象内存:27.728 KB
//		对象内存:14.464 KB
	}

}
