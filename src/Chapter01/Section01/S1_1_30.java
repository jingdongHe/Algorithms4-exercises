package Chapter01.Section01;

public class S1_1_30 {
	private static int gcd(int a,int b) {
		return a == 0 ? b : gcd(b % a, a); 
	}
	private static boolean prime(int a,int b) {
		return gcd(a,b)==1;
	}

	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		boolean table[][]=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(prime(i,j))
					table[i][j]=true;
			}
		}
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				System.out.print(table[i][j]?1:0);
			}
			System.out.println();
		}

	}

}
