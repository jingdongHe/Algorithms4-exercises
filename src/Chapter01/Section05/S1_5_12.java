package Chapter01.Section05;
class CompressWeightQuickUnion extends WeightQuickUnion{

	public CompressWeightQuickUnion(int N) {
		super(N);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int find(int p) {
		// TODO Auto-generated method stub
		int origin=p;
		while(p!=id[p])	{
			p=id[p];
		}
		id[origin]=p;
		return p;
	}
	
}
public class S1_5_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] link= {
				{9,0},{3,4},{5,8},{7,2},
				{2,1},{5,7},{0,3},{4,2},
		};
		int N=10;
		
		UnionFind cwqu=new CompressWeightQuickUnion(N);
		for(int i=0;i<link.length;i++) {
			if(!cwqu.connected(link[i][0], link[i][1]))
				cwqu.union(link[i][0], link[i][1]);
		}
		cwqu.print();
	}

}
