package Chapter03;

public class S3_1_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=100000;
		BinarySearchST<Integer, Integer> st=new BinarySearchST(10);
		long startTime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			st.put(i, i);
		System.out.println("�޸�ǰ��"+(System.currentTimeMillis()-startTime));
		
		st=new BinarySearchST(10);
		startTime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			st.smartPut(i, i);
		System.out.println("�޸ĺ�"+(System.currentTimeMillis()-startTime));
		
		// Ч�ʴ������
//		�޸�ǰ��36
//		�޸ĺ�22
	}

}
