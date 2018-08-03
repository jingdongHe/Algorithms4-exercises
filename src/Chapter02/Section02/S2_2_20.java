package Chapter02.Section02;

class IndirectMergeSort extends InplaceMergeSort{
	int[] perm;
	int[] permAux;
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		permAux=new int[a.length];
		perm=new int[a.length];
		for(int i=0;i<a.length;i++)
			perm[i]=i;
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
			permAux[k]=perm[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) perm[k]=permAux[j++];
			else if(j>hi) perm[k]=permAux[i++];
			else if(Merging.less(a[permAux[j]], a[permAux[i]]))	perm[k]=permAux[j++];
			else perm[k]=permAux[i++];
		}
	}
	public int[] perm() {
		return perm;
	}
}

public class S2_2_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T","0"};
		
		IndirectMergeSort sort=new IndirectMergeSort();
		sort.sort(s);
		for(int i:sort.perm()) {
			System.out.print(i+"["+s[i]+"] ");
		}
	}

}
