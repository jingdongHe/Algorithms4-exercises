package Chapter02.Section05;

import Chapter02.Section01.Selection;
import Chapter02.Section01.Sort;

class SelectionInRecursive extends Selection{
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		sort(a,0);
	}
	private void sort(Comparable[] a,int k) {
		if(k>=a.length) return;
		int min=k;
		for(int j=k+1;j<a.length;j++) {
			if(Sort.less(a[j],a[min])) min=j;
		}
		Sort.exch(a,k,min);
		sort(a,k+1);
	}
}

public class S2_5_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Selection selection=new SelectionInRecursive();
		String[] a= {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
		selection.sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}

}
