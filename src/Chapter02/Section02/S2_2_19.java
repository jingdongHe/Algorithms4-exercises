package Chapter02.Section02;

import Chapter02.Section01.Insertion;
import Chapter02.Section01.Sort;

class InplaceMergeSortCounter extends InplaceMergeSort {
	private int count;
	@Override
	public void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(Merging.less(aux[j], aux[i]))	{
				a[k]=aux[j++];
				// 前半部分数组全部后移1位
				count+=mid-i+1;
			}
			else a[k]=aux[i++];
		}
	}
	public int count() {
		return count;
	}
}

class InsertionCount extends Insertion{
	int count;
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N=a.length;
		for(int i=1;i<N;i++) {
			for(int j=i;j>0&&Sort.less(a[j],a[j-1]);j--)
			{
				Sort.exch(a, j, j-1);
				count++;
			}
		}
	}
	public int count() {
		return count;
	}
}
public class S2_2_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T","0"};
		String[] s1=s.clone();
		
		InplaceMergeSortCounter counter=new InplaceMergeSortCounter();
		counter.sort(s);
		Merging.print(s);
		System.out.println(counter.count());
		
		InsertionCount insert=new InsertionCount();
		insert.sort(s1);
		System.out.println(insert.count());
	}

}
