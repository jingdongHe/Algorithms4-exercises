package Chapter02.Section01;

public class Shell implements Sort{

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N=a.length;
		int h=1;
		while(h<N/3)	h=3*h+1;
//		Sort.show(a);
//		System.out.println("=========start===========");
		while(h>=1) {
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h&&Sort.less(a[j], a[j-h]);j-=h) {
					Sort.exch(a, j, j-h);
				}
			}
//			Sort.show(a);
			h=h/3;
		}
	}

}
