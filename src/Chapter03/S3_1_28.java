package Chapter03;

public class S3_1_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=100000;
		BinarySearchST<Integer, Integer> st=new BinarySearchST(10);
		long startTime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			st.put(i, i);
		System.out.println("修改前："+(System.currentTimeMillis()-startTime));
		
		st=new BinarySearchST(10);
		startTime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			st.smartPut(i, i);
		System.out.println("修改后："+(System.currentTimeMillis()-startTime));
		
		// 效率大大提升
//		修改前：36
//		修改后：22
	}

}
