package Chapter02.Section02;
class InplaceMergeSortCountCompareIgnoreMerge extends InplaceMergeSortCountCompare{
	@Override
	void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if(hi<=lo) return;
		count+=2;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		if(a[mid].compareTo(a[mid+1])>0)
			merge(a, lo, mid, hi);
	}
}
public class S2_2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a;
		for(int i=10;i<40;i++) {
			InplaceMergeSortCountCompareIgnoreMerge sort=new InplaceMergeSortCountCompareIgnoreMerge();
			a=new Integer[i];
			for(int j=0;j<i;j++)
				a[j]=j;
			sort.sort(a);
			System.out.println("N: "+i+" compare time: "+sort.count());
		}
	}
	// 不需要再merge中进行对比，只有sort中存在hi<=lo,及a[mid]<=a[mid+1] 2个对比
}
