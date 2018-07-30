package Chapter02.Section01;

class ShellInList extends Shell{
	public void sort(Comparable[] a,int[] list) {
		// TODO Auto-generated method stub
		int N=a.length;
		int h=0;
		while(list[h]<N/3)	h++;
//		Sort.show(a);
//		System.out.println("=========start===========");
		while(h>=0) {
			int H=list[h--];
//			System.out.println(H);
			for(int i=H;i<N;i++) {
				for(int j=i;j>=H&&Sort.less(a[j], a[j-H]);j-=H) {
					Sort.exch(a, j, j-H);
				}
			}
//			Sort.show(a);
		}
	}
}

public class S2_1_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShellInList shell = new ShellInList();
		int N=1000;
		Integer[] a=new Integer[N];
		for(int i=0;i<N;i++)
			a[i]=(int) (Math.random()*N);
		shell.sort(a,new int[]{1,4,13,40,121,364,1093});
	}

}
