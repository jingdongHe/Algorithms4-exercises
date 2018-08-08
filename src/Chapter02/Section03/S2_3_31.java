package Chapter02.Section03;

public class S2_3_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] a;
		int T=6;
		Quick quick=new Quick();
		long startTime;
		
		for(int N=1000;N<=1000000;N*=10) {
			a=new Double[N];
			for(int i=0;i<a.length;i++)
				a[i]=Math.random()*N;
			
			startTime = System.currentTimeMillis();
			for(int t=0;t<T;t++) {
				quick.sort(a.clone());
			}
			System.out.println("N:"+N+" time:"+(System.currentTimeMillis()-startTime)*1.0/T);
		}
		
//		N:1000 time:3.0
//		N:10000 time:37.333333333333336
//		N:100000 time:197.33333333333334
//		N:1000000 time:1607.0

	}

}
