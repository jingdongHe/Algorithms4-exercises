package Chapter03.Section03;

public class S3_3_20 {

	private static int internal(int n) {
		int k = (int) Math.sqrt(n);
		int count=0;
		for (int i = 1; i <= k; i++) {
			count+=i*Math.pow(2, i);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����֪������ƽ�������
		// ��i����ڲ�·��Ϊi����i�����2^i�����
		// n=2^k-1����������������Ҷ�ӽ����ͬһ��
		int n = (int) (Math.pow(2, 3) - 1);
		System.out.println(internal(n));
	}

}
