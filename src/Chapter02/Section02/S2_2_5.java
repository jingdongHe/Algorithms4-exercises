package Chapter02.Section02;
class MergeSortByBottomShowMerge extends MergeSortByBottom{
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		System.out.println("size is "+(hi-lo+1));
		for(int i=lo;i<=mid;i++)
			System.out.print(a[i]+" ");
		System.out.print("|");
		for(int i=mid+1;i<hi;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		super.merge(a, lo, mid, hi);
	}
}
public class S2_2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 39;
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		InplaceMergeSort sort;
		
		System.out.println("=============自底向上=============");
		sort=new MergeSortByBottomShowMerge();
		sort.sort(s.clone());
		System.out.println("=============自顶向下=============");
		sort=new InplaceMergeSortShowMerge();
		sort.sort(s.clone());
	}

}
