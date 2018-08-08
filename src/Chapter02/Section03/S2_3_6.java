package Chapter02.Section03;

class QuickCountCompare extends Quick{
	private int count;
	@Override
	boolean less(Comparable a, Comparable b) {
		// TODO Auto-generated method stub
		count++;
		return super.less(a, b);
	}
	public int count() {
		return count;
	}
}

public class S2_3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickCountCompare quick;
		
		int N;
		Integer[] a;
		
		N=100;
		quick=new QuickCountCompare();
		a=new Integer[N];
		for(int i=0;i<a.length;i++) a[i]=(int) (Math.random()*N);
		quick.sort(a);
		System.out.println(N+" : "+quick.count()+"<=>"+2*N*Math.log(N));
		
		N=1000;
		quick=new QuickCountCompare();
		a=new Integer[N];
		for(int i=0;i<a.length;i++) a[i]=(int) (Math.random()*N);
		quick.sort(a);
		System.out.println(N+" : "+quick.count()+"<=>"+2*N*Math.log(N));
		
		N=10000;
		quick=new QuickCountCompare();
		a=new Integer[N];
		for(int i=0;i<a.length;i++) a[i]=(int) (Math.random()*N);
		quick.sort(a);
		System.out.println(N+" : "+quick.count()+"<=>"+2*N*Math.log(N));
		
//		100 : 773<=>921.0340371976183
//		1000 : 13373<=>13815.510557964273
//		10000 : 167300<=>184206.80743952366
	}

}
