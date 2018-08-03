package Chapter02.Section02;

class InplaceMergeSortShowMerge extends InplaceMergeSort {
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		System.out.println("size is "+(hi-lo+1));
		for(int k=lo;k<=mid;k++)
			System.out.print(a[k]+" ");
		System.out.print("|");
		for(int k=mid+1;k<hi;k++)
			System.out.print(a[k]+" ");
		System.out.println();
		super.merge(a, lo, mid, hi);
	}
}

public class S2_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T"};
		
		InplaceMergeSort sort=new InplaceMergeSortShowMerge();
		sort.sort(s);
		Merging.print(s);
	}

}
