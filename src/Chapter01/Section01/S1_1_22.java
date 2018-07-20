package Chapter01.Section01;
class BinarySearch{
	private static int rank(int key,int[] a,int lo,int hi,int deep) {
		if(lo>hi) return -1;
		int mid=lo+(hi-lo)/2;
		
		if(key<a[mid])return rank(key,a,lo,mid-1,deep+1);
		else if (key>a[mid])return rank(key,a,mid+1,hi,deep+1);
		else	return mid;
		
	}
	public static int rank(int key,int[] a) {
		return rank(key,a,0,a.length-1,1);
	}
	
}
public class S1_1_22 {
	public static int rank(int key,int[] a) {
		return BinarySearch.rank(key,a);
	}

	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,8,10};
		System.out.println(rank(3,a));
	}

}
