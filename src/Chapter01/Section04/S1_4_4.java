package Chapter01.Section04;
class TwoSum{
	public static int count(int[] a) {
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++) {//运行时t1，频率1
			for(int j=i+1;j<N;j++) {//运行时t2，频率N
				if(a[i]+a[j]==0)//运行时t3，频率N^2/2
					cnt++;//运行时 t0，频率 x
			}
		}
		return cnt;
	}
	//总时间 t1+t2*N+t3*N^2/2+t0*x 近似（t3/2）*N^2
	//数量级 N^2
}
public class S1_4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
