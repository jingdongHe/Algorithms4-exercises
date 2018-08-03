package Chapter02.Section02;

public class MergeSortByBottom  extends InplaceMergeSort{

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N=a.length;
		aux=new Comparable[N];
		for(int sz=1;sz<N;sz*=2) {
			for(int lo=0;lo<N-sz;lo+=sz+sz) {
//				System.out.println(String.format("sort(%d,%d)", lo,Math.min(lo+sz+sz-1, N-1)));
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
