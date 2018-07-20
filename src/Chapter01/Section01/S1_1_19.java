package Chapter01.Section01;

public class S1_1_19 {
	private static long F(int N) {
		if(N==0)return 0;
		if(N==1)return 1;
		return F(N-1)+F(N-2);
	}
	private static long[] fibonacci(int N) {
		// 斐波那契数组实现
		long[] list=new long[N+1];
		list[0]=0;
		list[1]=1;
		for(int i=2;i<=N;i++) {
			list[i]=list[i-1]+list[i-2];
		}
		return list;
	}
	public static void main(String[] args) {
		for(int N=0;N<30;N++) {
			System.out.println(N+" "+F(N));
		}
		
		long[] fibonacci=fibonacci(100);
		for(int i=0;i<fibonacci.length;i++) {
			System.out.println(i+" "+fibonacci[i]);
		}
	}

}
