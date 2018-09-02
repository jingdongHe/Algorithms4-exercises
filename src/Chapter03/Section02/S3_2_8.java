package Chapter03.Section02;

public class S3_2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 完全二叉树，可以通过log来计算该结点的内部路径长度
		int N=8;
		double pathSum=0;
		double log2=Math.log(2);
		for(int i=2;i<=N;i++) 
			pathSum+=Math.ceil(Math.log(i)/log2);
		System.out.println(pathSum/N+1);
	}

}
