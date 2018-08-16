package Chapter02.Section04;
class Euclidean implements Comparable<Euclidean> {
	long desc;
    int x,y,z;
	public Euclidean(int x, int y, int z) {
		this.desc = x*x+y*y+z*z;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Euclidean o) {
		// TODO Auto-generated method stub
		if (this.desc < o.desc) return -1;
        if (this.desc > o.desc) return +1;
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%6d = %4d^2 + %4d^2 + %4d^2", this.desc,this.x,this.y,this.z);
	}
}
public class S2_4_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPQ<Euclidean> pq=new MinPQ<Euclidean>(1000);
		int N=10000;int M=10;
		
		for(int i=0;i<=N;i++)
			pq.insert(new Euclidean((int)(Math.random()*N),(int)(Math.random()*N),(int)(Math.random()*N)));
		
		for(int i=0;i<M;i++)
			System.out.println(pq.delMin());
	}
}
