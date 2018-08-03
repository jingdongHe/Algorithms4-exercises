package Chapter02.Section02;

class MergeSortByBottomWithNatural  extends InplaceMergeSort{

	private boolean isSort(Comparable[] a) {
		for(int i=1;i<a.length;i++)
			if(a[i-1].compareTo(a[i])>0) return false;
		return true;
	}
	
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N=a.length;
		aux=new Comparable[N];
		int tail=0;
		int lo = 0,mid,hi;
		
		while(isSort(a)==false) {
			if(tail>=N-1) tail=0;
			
			lo=tail;
			while(tail+1<N&&a[tail].compareTo(a[tail+1])<0)	tail++;
			mid=tail;tail++;
			while(tail+1<N&&a[tail].compareTo(a[tail+1])<0) tail++;
			hi=tail;
			merge(a, lo, mid, hi);
			tail++;
		}
		
	}

}

public class S2_2_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] s= {5,2,1,9,7};
		
		InplaceMergeSort sort=new MergeSortByBottomWithNatural();
		sort.sort(s);
		Merging.print(s);
	}

}
