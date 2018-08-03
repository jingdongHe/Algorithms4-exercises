package Chapter02.Section02;

public class InplaceMergeSort implements Merging {
	Comparable[] aux;
	// ∂‘a[0]~a[length-1]≈≈–Ú
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		aux=new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}

	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(Merging.less(aux[j], aux[i]))	a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
