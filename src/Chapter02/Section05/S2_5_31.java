package Chapter02.Section05;

import java.util.Arrays;

public class S2_5_31 {

	private static int getSame(int[] a) {
		// 先排序，后遍历数组数组找出重复的个数，时间NlogN
		int count=0;
		Arrays.sort(a);
		for(int i=a.length-1;i>0;i--) {
			if(a[i]==a[i-1]) count++;
			while(i>0&&a[i]==a[i-1]) {
				count++;
				i--;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N,T=10,M;
		int[] a;
		for(N=1000;N<=1000000;N*=10) {
			a=new int[N];
			System.out.print(String.format("N:%8d", N));
			for(M=N/2;M<=N*2;M*=2) {
				long count=0;
				for(int t=0;t<T;t++) {
					for(int i=0;i<N;i++) {
						a[i]=(int) (Math.random()*M);
					}
					count+=getSame(a);
				}
				System.out.print(String.format(" M: %7d=>%6d(%4.3f,%4.3f)", M,count/T,count*1.0/T/N,(1-Math.pow(Math.E, N*-1.0/M))));
			}
			System.out.println();
		}
	}

}
