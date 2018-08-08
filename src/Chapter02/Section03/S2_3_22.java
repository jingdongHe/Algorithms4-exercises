package Chapter02.Section03;

class QuickThreeDiect extends Quick{
//	void sort(Comparable[] a,int lo,int hi) {
//		if(hi<=lo) return;
//		int lt=lo,i=lo+1,gt=hi;
//		Comparable v=a[lo];
//		while(i<=gt) {
//			int cmp=a[i].compareTo(v);
//			if(cmp<0)	exch(a, lt++, i++);
//			else if(cmp>0)	exch(a, i, gt--);
//			else i++;
//		}
//		sort(a,lo,lt-1);
//		sort(a,gt+1,hi);
//	}
	public void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}
	
	void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int p=lo,i=lo+1,q=hi+1,j=hi;
		Comparable v=a[lo];
		while(i<=j) {
			int cmpI=a[i].compareTo(v);
			if(cmpI==0)	exch(a, ++p, i++);
			else if(cmpI<0)	i++;
			else if(cmpI>0)	exch(a, i, j--);
			
			if(i>j) break;
			
			int cmpJ=a[j].compareTo(v);
			if(cmpJ==0)	exch(a, --q, j--);
			else if(cmpJ>0)	j--;
			else if(cmpJ<0)	exch(a, i++, j);
		}
		while(p>=lo)	exch(a, j--, p--);
		while(q<=hi)	exch(a, q++, i++);
		sort(a,lo,j);
		sort(a,i,hi);
	}
}

public class S2_3_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=100;
		Quick quick=new QuickThreeDiect();
		Integer[] a=new Integer[N];
		for(int i=0;i<a.length;i++)
			a[i]=(int) (Math.random()*N);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		quick.sort(a);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
