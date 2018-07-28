package Chapter01.Section05;

public class S1_5_23 {
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
		int T=30,N=100,i=0;
		double ratio=0;
		
		
		while(i++<10) {
			double timeQuickUnion=excTime(T,N,new QuickUnion(N));
			double timeQuickFind=excTime(T,N,new QuickFind(N));
			double timeWeightQuickUnion=excTime(T,N,new WeightQuickUnion(N));
			N*=2;ratio=timeQuickUnion/timeQuickFind;
			System.out.println(String.format("N:%d;QuickFind:%.6f;QuickUnion:%.6f;WeightQuickUnion:%.6f;\n\nratio:%.6f;ratio:%.6f;ratio:%.6f;\n=======================\n", N/2,timeQuickFind,timeQuickUnion,timeWeightQuickUnion,
					timeQuickFind/timeWeightQuickUnion,timeQuickUnion/timeQuickFind,timeQuickUnion/timeWeightQuickUnion));
		}
	}

}
