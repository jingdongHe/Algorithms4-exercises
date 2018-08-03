package Chapter02.Section02;
class LessSpaceMergeSort{

	void exch(Comparable[] a, int i, int j) {
		Comparable temp=a[i];a[i]=a[j];a[j]=temp;
	}
	void insertSort(Comparable[] a, int lo, int hi) {
		for(int i=lo+1;i<=hi;i++) {
			for(int j=i;j>lo&&a[j].compareTo(a[j-1])<0;j--)
				exch(a, j, j-1);
		}
	}
	public void sort(Comparable[] a,int M){
		int N=a.length;
		for(int i=0;i<N/M;i++) {
			insertSort(a, i*M, (i+1)*M-1);
		}
		Merging.print(a);
		System.out.println("==============");
		for(int i=0;i<N/M;i++) {
			merge(a, i*M,(i+1)*M-1);
		}
	}
	public void merge(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		Comparable[] aux=new Comparable[hi+1];
		int mid=lo+(hi-lo)/2;
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
public class S2_2_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 此题不明白题目的意思，暂时搁置，准备看下原文
		Integer[] s= {5,6,8,9,4,6,2,1,9,8,4,1,6,5,4};
		
		LessSpaceMergeSort sort=new LessSpaceMergeSort();
		sort.sort(s,5);
		Merging.print(s);
	}

}
