package Chapter02.Section01;

public class Insertion implements Sort{

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
//		Sort.show(a);
//		System.out.println("===========start============");
		int N=a.length;
		for(int i=1;i<N;i++) {
			for(int j=i;j>0&&Sort.less(a[j],a[j-1]);j--)
				Sort.exch(a, j, j-1);
//			Sort.show(a);
		}
	}
	public void sort(Comparable[] a,int lo,int hi) {
		for(int i=lo+1;i<hi+1;i++) {
			for(int j=i;j>lo&&Sort.less(a[j],a[j-1]);j--)
				Sort.exch(a, j, j-1);
		}
	}
	public Integer[] indirectSort(Comparable[] a) {
		Integer[] index=new Integer[a.length];
		for(int i=0;i<index.length;i++)
			index[i]=i;
		for(int i=1;i<index.length;i++) {
			for(int j=i;j>0&&Sort.less(a[index[j]],a[index[j-1]]);j--)
				Sort.exch(index, j, j-1);
		}
		return index;
	}
}
