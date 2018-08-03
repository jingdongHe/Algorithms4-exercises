package Chapter02.Section02;

class InplaceMergeSortShowSort extends InplaceMergeSort {
	@Override
	void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		System.out.println(String.format("sort(%d,%d)",lo,hi));
		super.sort(a, lo, hi);
	}
}
public class S2_2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T"};
		
		InplaceMergeSort sort=new InplaceMergeSortShowSort();
		sort.sort(s);
		Merging.print(s);
	}	

}
