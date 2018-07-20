package Chapter01.Section02;

import java.util.Arrays;

class Counter{
	int count;
	public Counter() {
		count=0;
	}
	public void increment() {
		count++;
	}
	@Override
	public String toString() {
		return ""+count;
	}
	
}
class BinarySearch{
	private static int rank(int key,int[] a,int lo,int hi,int deep) {
		if(lo>hi) return -1;
		int mid=lo+(hi-lo)/2;
		
		if(key<a[mid])return rank(key,a,lo,mid-1,deep+1);
		else if (key>a[mid])return rank(key,a,mid+1,hi,deep+1);
		else	return mid;
		
	}
	public static int rank(int key,int[] a) {
		Arrays.sort(a);
		return rank(key,a,0,a.length-1,1);
	}
	private static int rank(int key,int[] a,int lo,int hi,Counter counter) {
		if(lo>hi) return -1;
		int mid=lo+(hi-lo)/2;
		counter.increment();
		
		if(key<a[mid])return rank(key,a,lo,mid-1,counter);
		else if (key>a[mid])return rank(key,a,mid+1,hi,counter);
		else	return mid;
		
	}
	public static int rank(int key,int[] a,Counter counter) {
		Arrays.sort(a);
		return rank(key,a,0,a.length-1,counter);
	}
	
}
public class S1_2_9 {

	public static void main(String[] args) {
		Counter counter=new Counter();
		System.out.println(BinarySearch.rank(6, new int[]{1,3,5,7,5,4,2,3,6,1,4,8,9,5,7},counter));
		System.out.println(counter);
	}

}
