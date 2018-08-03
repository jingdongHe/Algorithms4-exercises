package Chapter02.Section02;
class NMergeSort implements Merging {
	Comparable[] aux;
	// ∂‘a[0]~a[length-1]≈≈–Ú
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		aux=new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	public void sort(Comparable[] a,int N) {
		// TODO Auto-generated method stub
		aux=new Comparable[a.length];
		sort(a,0,a.length-1,N);
	}
	void sort(Comparable[] a,int lo,int hi,int N) {
		if(hi<=lo) return;
		if(hi-lo==1) {
			merge(a, lo, lo+(hi-lo)/2, hi);
			return; 
		}
		int[] mid=new int[N-1];
		for(int i=1;i<N;i++)
			mid[i-1]=lo+(hi-lo)/N*i;
		int mid1=lo+(hi-lo)/3,mid2=lo+(hi-lo)/3*2;
		sort(a,lo,mid[0]);
		sort(a,mid[0]+1,mid[1]);
		sort(a,mid[1]+1,hi);
		merge(a,lo,mid,hi);
	}
	// [lo,hi]
	void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		if(hi-lo==1) {
			merge(a, lo, lo+(hi-lo)/2, hi);
			return; 
		}
		int N=4;
		int[] mid=new int[N-1];
		for(int i=1;i<N;i++)
			mid[i-1]=lo+(hi-lo)/N*i;
		int mid1=lo+(hi-lo)/3,mid2=lo+(hi-lo)/3*2;
		sort(a,lo,mid[0]);
		sort(a,mid[0]+1,mid[1]);
		sort(a,mid[1]+1,hi);
		merge(a,lo,mid,hi);
	}
	private int less(Comparable[] a,int[] index,int[] mid,int hi) {
		Comparable min=null;
		int lessIndex=-1;
		int[] lessMid=new int[mid.length+1];
		for(int i=0;i<mid.length;i++)
			lessMid[i]=mid[i];
		lessMid[mid.length]=hi;
		
		for(int i=0;i<index.length;i++) {
			if(index[i]<=lessMid[i]) {
				if(min==null||a[index[i]].compareTo(min)<0) {
					min=a[index[i]];lessIndex=i;
				}
			}
		}
		return index[lessIndex]++;
	}
	public void merge(Comparable[] a, int lo, int[] mid, int hi){
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		int[] index=new int[mid.length+1];
		for(int i=0;i<mid.length;i++)
			index[i+1]=mid[i]+1;
		index[0]=lo;
		
		for(int z=lo;z<=hi;z++) {
			int less=less(aux,index,mid,hi);
			a[z]=aux[less];
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
public class S2_2_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] s= {3,1,4,5,3,9,8,7,6,5,1,3};
		// 1 1 3 3 3 4 5 5 6 7 8 9 
		NMergeSort sort=new NMergeSort();
		sort.sort(s,5);
		for(int i:s) {
			System.out.print(i+" ");
		}
	}

}
