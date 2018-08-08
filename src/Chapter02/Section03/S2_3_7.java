package Chapter02.Section03;
class QuickCountSmallList extends Quick{
	private int count;
	void sort(Comparable[] a,int lo,int hi) {
		if(hi-lo<=2) count++;
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	public int count() {
		return count;
	}
}
public class S2_3_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickCountSmallList quick;
		int N;
		Integer[] a;
		
		N=10000;
		quick=new QuickCountSmallList();
		a=new Integer[N];
		for(int i=0;i<a.length;i++) a[i]=i;
		quick.sort(a);
		System.out.println(N+" : "+quick.count()+" ratio "+quick.count()*1.0/N);
//		经过乱序的无重复数组，生成的近似一棵平衡树
//		经多次计算，约为0.93
	}

}
