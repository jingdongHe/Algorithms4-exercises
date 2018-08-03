package Chapter02.Section02;
class InplaceMergeSortAuxInMerge extends InplaceMergeSort{
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		sort(a,0,a.length-1);
	}
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		aux=new Comparable[a.length];
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(Merging.less(aux[j], aux[i]))	a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
}
public class S2_2_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100000;
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		
		long startTime;
		InplaceMergeSort sort1 = new InplaceMergeSort();
		System.out.println("在sort中创建aux");
		startTime=System.currentTimeMillis();
		sort1.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
		
		InplaceMergeSortAuxInMerge sort2=new InplaceMergeSortAuxInMerge();
		System.out.println("在merge中创建aux");
		startTime=System.currentTimeMillis();
		sort2.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
		//在merge中创建aux效率要慢得多
//		在sort中创建aux
//		185
//		在merge中创建aux
//		9974

	}

}
