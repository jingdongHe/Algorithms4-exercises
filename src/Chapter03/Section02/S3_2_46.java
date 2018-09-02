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
		// �˴���ʵ��������ĿԤ���г���
		// ��ʵ���У����ű��Ч��Ҫ�����ڶ��ֲ���
		// �������Ͻ�����N=10^4��N=10^5ʵ���У������С
		// ע�����ű�����ֲ��Ҷ��Ǻܿ�Ĳ��ҷ�����Ҫ�ﵽ1k����Ч�ʣ�NֵҪ�ǳ��Ĵ�
	}

}
