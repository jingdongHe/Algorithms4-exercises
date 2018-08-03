package Chapter02.Section02;

class InplaceMergeSortCountAnotherList extends InplaceMergeSort{
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) {
				a[k]=aux[j++];
				System.out.println("右边剩余"+(hi-j+1));
			}
			else if(j>hi) {
				a[k]=aux[i++];
				System.out.println("左边剩余"+(mid-i+1));
			}
			else if(Merging.less(aux[j], aux[i]))	a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
}

public class S2_2_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1000000;
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
		
		long startTime;
		InplaceMergeSort sort1 = new InplaceMergeSortCountAnotherList();
		startTime=System.currentTimeMillis();
		sort1.sort(s.clone());
		System.out.println(System.currentTimeMillis()-startTime);
		
//		经实验，绝大多数剩余的数量在0,2之间，未有超过10的情况
//		由于归并排序，生成的是平衡树，左右大小较为类似
	}

}
