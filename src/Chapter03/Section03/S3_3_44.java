package Chapter03.Section03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Chapter03.Section02.BST;

public class S3_3_44 {
	
	private static void statistics(int N,int t) {
		RedBlackBST<Integer, String> bst=new RedBlackBST<>();
		List<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			list.add(i);
		}
		Collections.shuffle(list);;
		
		Integer[] a=new Integer[N];
		list.toArray(a);
		
		for(int i=0;i<N;i++)
			bst.put(a[i], null);
		
		double c=0;
		double[] result=new double[t];
		for(int i=0;i<t;i++) {
			result[i]=bst.getPaht(bst.root, (int) (Math.random()*N), 0);
			c+=result[i];
		}
		double AM=0,SD=0;
		double avg=c/t;
		for(int i=0;i<t;i++) {
			AM+=Math.abs(result[i]-avg);
			SD+=(result[i]-avg)*(result[i]-avg);
		}
		System.out.println("N:"+N+"average deviation:"+avg/t+",standard deviation:"+Math.sqrt(SD/N));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10000;i++)
			statistics(i,1000);
	}

}
