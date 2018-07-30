package Chapter02.Section01;

class IntSort
{
	public void sort(int[] a) {
		int N=a.length;
		for(int i=1;i<N;i++) {
			for(int j=i;j>0&&Sort.less(a[j],a[j-1]);j--)
				exch(a, j, j-1);
//			Sort.show(a);
		}
	};
	static boolean less(int v,int w) {
		return v<w;
	}
	static void exch(int[] a,int i,int j) {
		int t=a[i];a[i]=a[j];a[j]=t;
	}
	static void show(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	static boolean isSorted(int[] a) {
		for(int i=1;i<a.length;i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
}

public class S2_1_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=1000,T=10;
		
		IntSort intSort=new IntSort();
		long startTime=System.currentTimeMillis();
		int count=T;
		while(count-->0) {
			int[] a=new int[N];
			for(int i=0;i<N;i++)
				a[i]=(int) (Math.random()*N);
			intSort.sort(a);
		}
		long endTime=System.currentTimeMillis();
		double excTime=(double)(endTime-startTime)/T;
		
		
		SortCompare compare=new SortCompare();
		System.out.println(compare.timeRandomInput(new Insertion(), N, T));
		System.out.println(excTime);
		
		// 原始数据类型的排序处理要比自动装箱拆箱速度要快得多，越有1/3的增速
	}

}
