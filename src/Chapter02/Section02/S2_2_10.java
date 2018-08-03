package Chapter02.Section02;

class QuickMergeSort extends InplaceMergeSort{
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=hi;
		for(int k=lo;k<=mid;k++)
			aux[k]=a[k];
		for(int k=mid+1;k<=hi;k++) {
			aux[k]=a[hi-k+mid+1];
		}
		for(int k=lo;k<=hi;k++) {
			if(Merging.less(aux[j], aux[i]))	a[k]=aux[j--];
			else a[k]=aux[i++];
		}
	}
}

public class S2_2_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T"};
		
		InplaceMergeSort sort=new QuickMergeSort();
		sort.sort(s);
		Merging.print(s);
	}

}
