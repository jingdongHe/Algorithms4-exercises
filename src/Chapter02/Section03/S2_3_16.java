package Chapter02.Section03;

public class S2_3_16 {
	private static void exch(Comparable[] a,int i,int j) {
		Comparable v=a[i];a[i]=a[j];a[j]=v;
	}
	
	private static void createList(Comparable[] a,int lo,int hi) {
//		for(int i=0;i<a.length;i++)
//			System.out.print(a[i]+" ");
//		System.out.println();
		if(hi<=lo) return;
		int j=lo+(hi-lo)/2;
		createList(a,lo,j-1);
		createList(a,j+1,hi);
		exch(a,lo,j);
	}
	public static void createList(Comparable[] a) {
		for(int i=0;i<a.length;i++)
			a[i]=i;
		createList(a, 0, a.length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 要使排序的效果最佳，每次的a[lo]的正确位置都应该是在lo+(hi-lo)/2位置，此时生成的树最为平衡
		Integer[] a=new Integer[30];
		
		createList(a);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println("\n==============");
		
		Quick quick=new QuickWithoutShuffle();
		quick.sort(a);
	}

}
