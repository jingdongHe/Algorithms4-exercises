package Chapter01.Section04;
class TwoSum{
	public static int count(int[] a) {
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++) {//����ʱt1��Ƶ��1
			for(int j=i+1;j<N;j++) {//����ʱt2��Ƶ��N
				if(a[i]+a[j]==0)//����ʱt3��Ƶ��N^2/2
					cnt++;//����ʱ t0��Ƶ�� x
			}
		}
		return cnt;
	}
	//��ʱ�� t1+t2*N+t3*N^2/2+t0*x ���ƣ�t3/2��*N^2
	//������ N^2
}
public class S1_4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
