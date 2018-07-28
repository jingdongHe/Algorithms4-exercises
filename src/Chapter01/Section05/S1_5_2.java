package Chapter01.Section05;

class QuickUnion extends UnionFind{

	public QuickUnion(int N) {
		super(N);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int find(int p) {
		// TODO Auto-generated method stub
		while(p!=id[p]) p=id[p];
		return p;
	}
	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		int pRoot=find(p);
		int qRoot=find(q);
		if(pRoot!=qRoot) {
			id[pRoot]=qRoot;
			count--;
		}
	}
}

public class S1_5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] link= {
				{9,0},{3,4},{5,8},{7,2},
				{2,1},{5,7},{0,3},{4,2}
		};
		int N=10;
		
		UnionFind qf=new QuickUnion(N);
		for(int i=0;i<link.length;i++) {
			if(!qf.connected(link[i][0], link[i][1]))
				qf.union(link[i][0], link[i][1]);
		}
		qf.print();
	}

}
