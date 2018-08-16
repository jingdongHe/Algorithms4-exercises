package Chapter02.Section04;

class CubeSum implements Comparable<CubeSum> {
	long sum;
    int i;
    int j;
    public CubeSum(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }
	@Override
	public int compareTo(CubeSum o) {
		// TODO Auto-generated method stub
		if (this.sum < o.sum) return -1;
        if (this.sum > o.sum) return +1;
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%6d = %4d^3 + %4d^3", this.sum,this.i,this.j);
	}
}
public class S2_4_25 {
	public static void main(String[] args) {
//		MinPQ<CubeSum> pq=new MinPQ<CubeSum>(10);
//		int N=1000000;
//		
//		for(int i=0;i<=N;i++)
//			pq.insert(new CubeSum(i, 0));
//		
//		while(!pq.isEmpty()) {
//			CubeSum sum=pq.delMin();
//			System.out.println(sum);
//			if(sum.j<N)
//				pq.insert(new CubeSum(sum.i, sum.j+1));
//		}
		
		MinPQ<CubeSum> pq=new MinPQ<CubeSum>(1000);
		int N=10000;
		
		for(int i=0;i<=N;i++)
			pq.insert(new CubeSum(i, 0));
		
		while(!pq.isEmpty()) {
			CubeSum sum=pq.delMin();
			CubeSum top=pq.min();
			if(sum.sum==top.sum&&sum.i!=top.i&&sum.i!=top.j&&sum.j!=top.i&&sum.j!=top.j)
				System.out.println(sum.sum+":"+sum.i+" "+sum.j+" "+top.i+" "+top.j);
			if(sum.j<N) {
				pq.insert(new CubeSum(sum.i, sum.j+1));
			}
		}
	}
}
