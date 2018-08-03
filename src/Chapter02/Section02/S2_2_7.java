package Chapter02.Section02;

class InplaceMergeSortCountCompare extends InplaceMergeSort{
	int count=0;
	@Override
	void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		count++;
		super.sort(a, lo, hi);
	}
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			count++;
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(Merging.less(aux[j], aux[i]))	a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	public int count() {
		return count;
	}
}

public class S2_2_7 {
	public static void main(String[] args) {
		Double[] a;
		for(int i=10;i<40;i++) {
			InplaceMergeSortCountCompare sort=new InplaceMergeSortCountCompare();
			a=new Double[i];
			for(int j=0;j<i;j++)
				a[j]=Math.random()*i;
			sort.sort(a);
			System.out.println("N: "+i+" compare time: "+sort.count());
		}
	}
}
