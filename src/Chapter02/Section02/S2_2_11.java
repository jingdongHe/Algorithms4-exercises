package Chapter02.Section02;

import Chapter02.Section01.Sort;

class InsertMergeSort extends InplaceMergeSort{
	
	@Override
	void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		// 左半边
		if(mid-lo+1<15)
			insertSort(a, lo, mid);
		else
			sort(a,lo,mid);
		// 右半边
		if(hi-mid<15)
			insertSort(a, mid+1, hi);
		else
			sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	void exch(Comparable[] a, int i, int j) {
		Comparable temp=a[i];a[i]=a[j];a[j]=temp;
	}
	void insertSort(Comparable[] a, int lo, int hi) {
		for(int i=lo+1;i<=hi;i++) {
			for(int j=i;j>lo&&a[j].compareTo(a[j-1])<0;j--)
				exch(a, j, j-1);
		}
	}
}

class InplaceMergeSortWithoutCopy extends InplaceMergeSort{
	
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		// 注意aux的初始化，否则会出现无值得情况
		aux=a.clone();
		sort(aux,a,0,a.length-1);
	}
	// a ==> aux
	void sort(Comparable[] a,Comparable[] aux, int lo, int hi) {
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(aux,a,lo,mid);
		sort(aux,a,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}
	
	public void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++) {
			if(i>mid) aux[k]=a[j++];
			else if(j>hi) aux[k]=a[i++];
			else if(Merging.less(a[j], a[i]))	aux[k]=a[j++];
			else aux[k]=a[i++];
		}
	}
}

public class S2_2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 39;
		Integer[] s=new Integer[N];
		for(int i=0;i<N;i++)
			s[i]=(int) (Math.random()*N);
//		String[] s= {"A","E","Q","S","U","Y","E","I","N","O","S","T"};
		InplaceMergeSort sort;
		System.out.println("插入排序处理较小的数组");
		sort=new InsertMergeSort();
		Integer[] s1=s.clone();
		sort.sort(s1);
		Merging.print(s);
		Merging.print(s1);
		System.out.println("对左、右进行比较，减少merge");
		sort=new InplaceMergeSortCountCompareIgnoreMerge(); 
		Integer[] s2=s.clone();
		sort.sort(s2);
		Merging.print(s);
		Merging.print(s2);
		System.out.println("不进行辅助数组的复制");
		sort=new InplaceMergeSortWithoutCopy(); 
		Comparable[] s3=s.clone();
		sort.sort(s3);
		Merging.print(s);
		Merging.print(s3);
		
	}

}
