package Chapter01.Section05;

public class UnionFind {
	int[] id;
	int count;
	
	public UnionFind(int N) {
		// TODO Auto-generated constructor stub
		count=N;id=new int[N];
		for(int i=0;i<N;i++)
			id[i]=i;
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	public int find(int p) {
		return -1;
	}
	public void union(int p,int q) {
	}
	public void print() {
		for(int i=0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
}
