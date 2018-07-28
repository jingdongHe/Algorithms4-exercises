package Chapter01.Section05;
public class S1_5_22 {

	public static int count(int N,UnionFind uf) {
		int p,q,count = 0;
		do {
			p=(int) (Math.random()*N);
			while((q=(int) (Math.random()*N))==p)
				q=(int) (Math.random()*N);
			uf.union(p, q);
			count++;
		}while(uf.count()!=1);
		return count;
	}
	
	private static double excTime(int T,int N,UnionFind uf) {
		long startTime=System.currentTimeMillis();
		for(int i=0;i<T;i++)
			count(N,uf);
		long endTime=System.currentTimeMillis();
		double excTime=(double)(endTime-startTime)/T/1000;
		return excTime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T=30;
		int N=100;
		int i=1;
		
		double prev=0,ratio=0;
		System.out.println("加权quick-union算法");
		while(true) {
			double time=excTime(T,N,new WeightQuickUnion(N));
			N*=2;
			if(prev==0) {
				prev=time;
				continue;
			}
			ratio=time/prev;
			System.out.println(String.format("N:%d;prev:%.6f;time:%.6f;ratio:%.6f", N/2,prev,time,ratio));
			prev=time;
			if(i++>6)
				break;
		}
		
		N=100;i=1;
		prev=0;ratio=0;
		
		System.out.println("quick-union算法");
		while(true) {
			double time=excTime(T,N,new QuickUnion(N));
			N*=2;
			if(prev==0) {
				prev=time;
				continue;
			}
			ratio=time/prev;
			System.out.println(String.format("N:%d;prev:%.6f;time:%.6f;ratio:%.6f", N/2,prev,time,ratio));
			prev=time;
			if(i++>6)
				break;
		}
		
		
		N=100;i=1;
		prev=0;ratio=0;
		
		System.out.println("quick-find算法");
		while(true) {
			double time=excTime(T,N,new QuickFind(N));
			N*=2;
			if(prev==0) {
				prev=time;
				continue;
			}
			ratio=time/prev;
			System.out.println(String.format("N:%d;prev:%.6f;time:%.6f;ratio:%.6f", N/2,prev,time,ratio));
			prev=time;
			if(i++>6)
				break;
		}
	}

}
