package Chapter02.Section03;

import Chapter02.Section01.Insertion;

class QuickThreeDiectImp extends QuickThreeDiect{
	private int mid(Comparable[] a,int i,int j,int k) {
		int cmpIJ=a[i].compareTo(a[j]);
		int cmpIK=a[i].compareTo(a[k]);
		int cmpJK=a[j].compareTo(a[k]);
		if((cmpIJ<=0&&cmpIK>=0)||(cmpIJ>=0&&cmpIK<=0))
			return i;
		else if((cmpIJ<=0&&cmpJK<=0)||(cmpIJ>=0&&cmpJK>=0))
			return j;
		return k;
	}
	public void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}
	void sort(Comparable[] a,int lo,int hi) {
		if(hi-lo+1<15) {
			Insertion insert=new Insertion();
			insert.sort(a,lo,hi);
			return;
		}
		if(hi<=lo) return;
		int p=lo,i=lo+1,q=hi+1,j=hi;
		int mid=mid(a,mid(a,lo+0,lo+1,lo+2),mid(a,lo+3,lo+4,lo+5),mid(a,lo+6,lo+7,lo+8));
		exch(a, mid, lo);
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
public class S2_3_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=100;
		Quick quick=new QuickThreeDiectImp();
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
