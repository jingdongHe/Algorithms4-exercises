package Chapter03.Section02;

public class S3_2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ��ȫ������������ͨ��log������ý����ڲ�·������
		int N=8;
		double pathSum=0;
		double log2=Math.log(2);
		for(int i=2;i<=N;i++) 
			pathSum+=Math.ceil(Math.log(i)/log2);
		System.out.println(pathSum/N+1);
	}

}
