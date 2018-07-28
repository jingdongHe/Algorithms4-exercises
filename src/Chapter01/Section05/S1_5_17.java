package Chapter01.Section05;

public class S1_5_17 {
	private static int count(int N) {
		WeightQuickUnion wqu=new WeightQuickUnion(N);
		int p,q,count = 0;
		do {
			p=(int) (Math.random()*N);
			while((q=(int) (Math.random()*N))==p)
				q=(int) (Math.random()*N);
			wqu.union(p, q);
			System.out.println(p+" "+q);
			count++;
		}while(wqu.count()!=1);
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=100;
		
		System.out.println("need link "+count(N));
	}

}
