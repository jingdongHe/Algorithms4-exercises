package Chapter02.Section01;

class RatioShell extends Shell{
	int compareTime;
	
	private boolean less(Comparable v,Comparable w) {
		// TODO Auto-generated method stub
		compareTime++;
		return Sort.less(v, w);
	}
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N=a.length;
		int h=1;
		while(h<N/3)	h=3*h+1;
		while(h>=1) {
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h&&less(a[j], a[j-h]);j-=h) {
					Sort.exch(a, j, j-h);
				}
			}
			System.out.println(String.format("h:%6d;compare time:%8d;array length:%8d;ratio:%.6f", h,compareTime,a.length,compareTime*1.0/a.length));
			h=h/3;compareTime=0;
		}
	}
}
public class S2_1_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shell shell=new RatioShell();

		int N=100;
		for(int i=0;i<5;i++) {
			System.out.println("N is :"+N);
			Double[] a=new Double[N];
			for(int j=0;j<a.length;j++)
				a[j]=Math.random();
			shell.sort(a);
			N*=10;
		}
	}

}
