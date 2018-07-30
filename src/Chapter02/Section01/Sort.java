package Chapter02.Section01;
public interface Sort
{
	public void sort(Comparable[] a);
	static boolean less(Comparable v,Comparable w) {
		try {
			return v.compareTo(w)<0;
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println(e);
			return v.toString().compareTo(w.toString())<0;
		}
	}
	static void exch(Comparable[] a,int i,int j) {
		Comparable t=a[i];a[i]=a[j];a[j]=t;
	}
	static void show(Comparable[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	static boolean isSorted(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
}
