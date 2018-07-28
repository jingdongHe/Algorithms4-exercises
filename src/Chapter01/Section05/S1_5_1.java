package Chapter01.Section05;

class QuickFind extends UnionFind{
	int[] visit;
	public QuickFind(int N) {
		super(N);
		visit=new int[N];
		// TODO Auto-generated constructor stub
	}
	public int find(int p) {
		return id[p];
	}
	public void union(int p,int q) {
		int pID=find(p);
		int qID=find(q);
		
		if(pID==qID) return;
		
		for(int i=0;i<id.length;i++) {
			if(id[i]==pID) {
				id[i]=qID;
				visit[i]++;
			}
		}
		count--;
	}
	public void print() {
		super.print();
		for(int i=0;i<id.length;i++)
			System.out.print(visit[i]+" ");
		System.out.println();
	}
}

public class S1_5_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] link= {
				{9,0},{3,4},{5,8},{7,2},
				{2,1},{5,7},{0,3},{4,2}
		};
		int N=10;
		
		UnionFind qf=new QuickFind(N);
		for(int i=0;i<link.length;i++) {
			if(!qf.connected(link[i][0], link[i][1]))
				qf.union(link[i][0], link[i][1]);
		}
		qf.print();
	}

}
