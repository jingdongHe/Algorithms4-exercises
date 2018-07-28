package Chapter01.Section05;

class WeightQuickUnion extends UnionFind{
	int[] visit;
	int[] sz;
	public WeightQuickUnion(int N) {
		super(N);
		// TODO Auto-generated constructor stub
		sz=new int[N];visit=new int[N];
		for(int i=0;i<N;i++)	sz[i]=1;
	}
	@Override
	public int find(int p) {
		// TODO Auto-generated method stub
		while(p!=id[p])	p=id[p];
		return p;
	}
	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		int pRoot=find(p);
		int qRoot=find(q);
		if(pRoot!=qRoot) {
			if(sz[pRoot]<sz[qRoot]) {
				id[pRoot]=qRoot;
				sz[qRoot]+=sz[pRoot];
				visit[pRoot]++;
			}else {
				id[qRoot]=pRoot;
				sz[pRoot]+=sz[qRoot];
				visit[qRoot]++;
			}
			count--;
		}
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		for(int i=0;i<sz.length;i++)
			System.out.print(sz[i]+" ");
		System.out.println();
		for(int i=0;i<visit.length;i++)
			System.out.print(visit[i]+" ");
		System.out.println();
	}

}

public class S1_5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] link= {
				{9,0},{3,4},{5,8},{7,2},
				{2,1},{5,7},{0,3},{4,2}
		};
		int N=10;
		
		UnionFind wqu=new WeightQuickUnion(N);
		for(int i=0;i<link.length;i++) {
			if(!wqu.connected(link[i][0], link[i][1]))
				wqu.union(link[i][0], link[i][1]);
		}
		wqu.print();
	}

}
