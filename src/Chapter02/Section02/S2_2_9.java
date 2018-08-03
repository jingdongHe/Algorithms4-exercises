package Chapter02.Section02;
class InplaceMergeSortOptAux extends InplaceMergeSort {
	
	// ∂‘a[0]~a[length-1]≈≈–Ú
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		Comparable[] aux;
		aux=new Comparable[a.length];
		sort(a,0,a.length-1,aux);
	}
	void sort(Comparable[] a,int lo,int hi,Comparable[] aux) {
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid,aux);
		sort(a,mid+1,hi,aux);
		merge(a,lo,mid,hi,aux);
	}

	public void merge(Comparable[] a, int lo, int mid, int hi,Comparable[] aux) {
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

}
public class S2_2_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a;
		for(int i=10;i<40;i++) {
			InplaceMergeSortOptAux sort=new InplaceMergeSortOptAux();
			a=new Integer[i];
			for(int j=0;j<i;j++)
				a[j]=(int) (Math.random()*i);
			sort.sort(a);
			Merging.print(a);
		}
	}

}
