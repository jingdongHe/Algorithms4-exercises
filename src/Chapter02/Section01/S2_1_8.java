package Chapter02.Section01;


public class S2_1_8 {

	private static double excTime(int T,Integer[] a,Sort sort) {
		long startTime=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			sort.sort(a);
		long endTime=System.currentTimeMillis();
		double excTime=(double)(endTime-startTime)/T/1000;
		return excTime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用倍率实验进行验证,得出结论，平方级
		int T=30,N=100;
		double prev=0;
		for(int i=0;i<12;i++) {
			Integer[] a=new Integer[N];
			for(int j=0;j<N;j++) {
				double temp=Math.random();
				if(temp<=1.0/3)	a[j]=-1;
				if(temp>1.0/3&&temp<=2.0/3)	a[j]=0;
				if(temp>2.0/3)	a[j]=1;
			}
			
			double time= excTime(T, a, new Insertion());
			System.out.println(String.format("N:%6d;prev:%9.6f;time:%9.6f;ratio:%3.2f", N,prev,time,time/prev));
			N=N*2;prev=time;
			
		}
	}

}
