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
	
}
