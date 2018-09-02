package Chapter03.Section02;

import Chapter03.Section01.BinarySearchST;

public class S3_2_46 {
	private static void ratio(int N) {
		BST<Double, Integer> bst=new BST<>();
		BinarySearchST<Double, Integer> st=new BinarySearchST<>(N);
		for(int i=0;i<N;i++) {
			double r=Math.random();
			bst.put(r, null);
			st.put(r, null);
		}
		long start;
		long bstTime,stTime;
		double r=Math.random();
		start=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			bst.get(r);
		bstTime=System.currentTimeMillis()-start;
		start=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			st.get(r);
		stTime=System.currentTimeMillis()-start;
		
		System.out.println(bstTime+","+stTime);
		System.out.println(bstTime*1.0/stTime);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ratio(100000);
		// 此处的实验结果与题目预测有出入
		// 在实验中，符号表的效率要稍慢于二分查找
		// 但，以上结论在N=10^4与N=10^5实验中，差距缩小
		// 注：符号表与二分查找都是很快的查找方法，要达到1k倍的效率，N值要非常的大
	}

}
