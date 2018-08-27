package Chapter03;

public class S3_1_32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=20;
		BinarySearchST<Integer, Integer> st=new BinarySearchST(10);
		for(int i=0;i<N;i++)
			st.put(i, i);
		st.print();
		
		st=new BinarySearchST(10);
		for(int i=0;i<N;i++)
			st.put(N-i, N-i);
		st.print();
		
		st=new BinarySearchST(10);
		for(int i=0;i<N;i++)
			st.put(0, i);
		st.print();
		
		st=new BinarySearchST(10);
		for(int i=0;i<N;i++)
			st.put(i%2, i);
		st.print();
	}

}
