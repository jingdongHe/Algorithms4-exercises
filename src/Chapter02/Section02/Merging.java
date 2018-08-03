package Chapter02.Section02;

public interface Merging {
	public void sort(Comparable[] a);
	public void merge(Comparable[] a,int lo,int mid,int hi);
	public static boolean less(Comparable a,Comparable b) {
		return a.compareTo(b)<0;
	}
	public static void print(Comparable[] a) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
