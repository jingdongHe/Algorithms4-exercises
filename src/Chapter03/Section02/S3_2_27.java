package Chapter03.Section02;

import java.lang.instrument.Instrumentation;

import Chapter03.Section01.BinarySearchST;
import Chapter03.Section01.SequentialSearchST;

public class S3_2_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=10000;
		long start = 0,end=0;
		System.gc();
		Runtime.getRuntime().freeMemory();
		
		System.gc();
		start = Runtime.getRuntime().freeMemory();
		BST<String, Integer> bst=new BST<>();
		for(int i=0;i<N;i++)
			bst.put((Math.random()*N)+"", i);
		System.gc();
		end = Runtime.getRuntime().freeMemory();
		System.out.println("对象内存:" + (start - end)/1000.0 + " KB");
		
		System.gc();
		start = Runtime.getRuntime().freeMemory();
		BinarySearchST<String, Integer> st=new BinarySearchST<>(10);
		for(int i=0;i<N;i++)
			st.put((Math.random()*N)+"", i);
		System.gc();
		end = Runtime.getRuntime().freeMemory();
		System.out.println("对象内存:" + (start - end)/1000.0 + " KB");
		
		System.gc();
		start = Runtime.getRuntime().freeMemory();
		SequentialSearchST<String, Integer> sst=new SequentialSearchST<>();
		for(int i=0;i<N;i++)
			sst.put((Math.random()*N)+"", i);
		System.gc();
		end = Runtime.getRuntime().freeMemory();
		System.out.println("对象内存:" + (start - end)/1000.0 + " KB");
		
		
//		对象内存:1399.152 KB
//		对象内存:1034.576 KB
//		对象内存:1272.512 KB
		
	}

}
