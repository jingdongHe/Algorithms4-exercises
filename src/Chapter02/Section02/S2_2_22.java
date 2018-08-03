package Chapter02.Section02;

class ThreeMergeSort implements Merging {
	Comparable[] aux;
	// ∂‘a[0]~a[length-1]≈≈–Ú
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		aux=new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	// [lo,hi]
	void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		if(hi-lo==1) {
			merge(a, lo, lo+(hi-lo)/2, hi);
			return; 
		}
		int mid1=lo+(hi-lo)/3,mid2=lo+(hi-lo)/3*2;
		sort(a,lo,mid1);
		sort(a,mid1+1,mid2);
		sort(a,mid2+1,hi);
		
		merge(a,lo,mid1,mid2,hi);
	}
	private int less(Comparable[] a,int i,int j,int k,int l1,int l2,int l3) {
		Comparable min=null;
		int index=-1;
		if(i<=l1) {
			if(min==null||a[i].compareTo(min)<0) {
				min=a[i];index=i;
			}
		}
		if(j<=l2) {
			if(min==null||a[j].compareTo(min)<0) {
				min=a[j];index=j;
			}
		}
		if(k<=l3) {
			if(min==null||a[k].compareTo(min)<0) {
				min=a[k];index=k;
			}
		}
		return index;
	}
	public void merge(Comparable[] a, int lo, int mid1,int mid2, int hi){
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		int i=lo,j=mid1+1,k=mid2+1;
		for(int z=lo;z<=hi;z++) {
			int less=less(aux,i,j,k,mid1,mid2,hi);
			a[z]=aux[less];
			if(i<=mid1&&less==i) i++;
			else if(j<=mid2&&less==j) j++;
			else if(k<=hi&&less==k) k++;
		}
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

}
public class S2_2_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] s= {3,1,4,5,3,9,8,7,6,5,1,3};
//		Integer[] s= {7,6,5,1,3};
		
		ThreeMergeSort sort=new ThreeMergeSort();
		sort.sort(s);
		for(int i:s) {
			System.out.print(i+" ");
		}
	}

}
