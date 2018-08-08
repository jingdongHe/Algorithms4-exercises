package Chapter02.Section03;

public class S2_3_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickCountCompare quick;
		
		int N;
		Integer[] a;
		
		N=1000;
		quick=new QuickCountCompare();
		a=new Integer[N];
		for(int i=0;i<a.length;i++) a[i]=1;
		quick.sort(a);
		System.out.println(N+" : "+quick.count()+"<=>"+Math.log(N)*N);
		
//		�²⣺ԼΪln(N)*N
	}

}
