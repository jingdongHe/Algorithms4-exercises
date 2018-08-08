package Chapter02.Section03;

import Chapter02.Section01.Insertion;

class QuickWithInsertCountDeep extends Quick{
	int count;
	void sort(Comparable[] a,int M) {
		sort(a,0,a.length-1,M,0);
	}
	void sort(Comparable[] a,int lo,int hi,int M,int deep) {
		count=count>deep?count:deep;
		if(hi-lo+1<M)
		{
			Insertion insert=new Insertion();
			insert.sort(a,lo,hi);
			return;
		}
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1,M,deep+1);
		sort(a,j+1,hi,M,deep+1);
	}
}
public class S2_3_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickWithInsertCountDeep quick;
		System.out.println("M\t10\t20\t50\t预估lgN-lg10");
		System.out.println("------------------------");
		for(int n=1000;n<=1000000;n*=10) {
			Integer[] a=new Integer[n];
			for(int i=0;i<a.length;i++)
				a[i]=(int) (Math.random()*n);
			
			System.out.print(n+"\t");
			quick=new QuickWithInsertCountDeep();
			quick.sort(a.clone(),10);
			System.out.print(quick.count+"\t");
			quick=new QuickWithInsertCountDeep();
			quick.sort(a.clone(),20);
			System.out.print(quick.count+"\t");
			quick=new QuickWithInsertCountDeep();
			quick.sort(a.clone(),50);
			System.out.print(quick.count+"\t");
			System.out.print(Math.log(n)-Math.log(10));
			System.out.println();
		}
//		M 越大，递归深度越小
//		预估为4*lgN-4*lgM
//		M	10	20	50	预估lgN-lg10
//		------------------------
//		1000	16	14	10	4.605170185988091
//		10000	29	26	22	6.907755278982138
//		100000	33	30	28	9.210340371976184
//		1000000	45	43	39	11.512925464970227
	}

}
