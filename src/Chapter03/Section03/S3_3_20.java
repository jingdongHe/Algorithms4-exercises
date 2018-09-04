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
		// 由题可知，完美平衡二叉树
		// 第i层的内部路径为i，第i层存在2^i个结点
		// n=2^k-1，表明该树的所以叶子结点在同一行
		int n = (int) (Math.pow(2, 3) - 1);
		System.out.println(internal(n));
	}

}
